package com.webservicejpa.config;

import com.webservicejpa.entities.User;
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
//    public void setDefaultValues() {
//        User user = new User(null, "Maria Lacerda", "maria@gmail.com", "9999999", "123456789");
//        User user2 = new User(null, "João Lucas", "joao@gmail.com", "88888888", "123456789");
//        getEntityManager().getTransaction().begin();
//        getEntityManager().persist(user);
//        getEntityManager().persist(user2);
//        getEntityManager().getTransaction().commit();
//    }
}
