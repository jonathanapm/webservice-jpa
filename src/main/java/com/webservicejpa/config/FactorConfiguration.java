package com.webservicejpa.config;

import com.webservicejpa.entities.*;
import com.webservicejpa.entities.enums.OrderStatus;
import com.webservicejpa.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.HashSet;

@Configuration
@EnableJpaRepositories(basePackages = "com.webservicejpa")
@EnableTransactionManagement
public class FactorConfiguration {

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
      return Persistence.createEntityManagerFactory("cadastros");
    }

    @Bean(name = "entityManager")
    public EntityManager getEntityManager() {
       return this.entityManagerFactory().createEntityManager();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager dbTransactionManager() { return new JpaTransactionManager(); }

//    @Bean
    public void setDefaultValues() {
        User user = new User(null, "Maria Lacerda", "maria@gmail.com", "9999999", "123456789");
        User user2 = new User(null, "João Lucas", "joao@gmail.com", "88888888", "123456789");
        getEntityManager().getTransaction().begin();

        getEntityManager().persist(user);
        getEntityManager().persist(user2);

        Order order1 = new Order(null, Instant.now(), OrderStatus.PAID, user);
        Order order2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT,  user2);
        Order order3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT,  user2);



        getEntityManager().persist(order1);
        getEntityManager().persist(order2);
        getEntityManager().persist(order3);

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        getEntityManager().persist(category1);
        getEntityManager().persist(category2);
        getEntityManager().persist(category3);

        Product product1 = new Product(null, "The lord of rings", "Os senhor dos anéis", 90.5, "");
        Product product2 = new Product(null, "Star Wars II", "Star Wars Episode II", 220.5, "");
        Product product3 = new Product(null, "Star Wars III", "Star Wars Episode III - Ameaça fantasma", 400.5, "");

        getEntityManager().persist(product1);
        getEntityManager().persist(product2);
        getEntityManager().persist(product3);

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);

        getEntityManager().persist(product1);
        getEntityManager().persist(product2);
        getEntityManager().persist(product3);

        OrderItem orderItem1 = new OrderItem(order1, product1,2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3,1, product1.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product2,5, product2.getPrice());

        getEntityManager().persist(orderItem1);
        getEntityManager().persist(orderItem2);
        getEntityManager().persist(orderItem3);

        Payment payment = new Payment(null, Instant.now().plusSeconds(6000L), order1);
        order1.setPayment(payment);

        getEntityManager().persist(order1);

        getEntityManager().getTransaction().commit();
    }
}
