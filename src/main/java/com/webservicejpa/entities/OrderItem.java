package com.webservicejpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.scenario.effect.impl.prism.PrDrawable;
import com.webservicejpa.entities.pk.OrderItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    //Quando é criado uma classe auxiliar (id composto), deve ser inicializada
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    private Integer quantity;

    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        this.quantity = quantity;
        this.price = price;
        id.setOrder(order);
        id.setProduct(product);
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

}
