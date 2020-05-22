package com.daniel.springdemo.demo.Entities;

import com.daniel.springdemo.demo.Entities.PK.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product,  Integer quantity, Double price) {
        this.id.setProduct(product);
        this.id.setOrder(order);

        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct (){
        return id.getProduct();
    }

    @JsonIgnore
    public Order getOrder (){
        return id.getOrder();
    }

    public void setProduct (Product product){
        id.setProduct(product);
    }

    public void settOrder (Order order){
        id.setOrder(order);
    }

    @JsonProperty("Sub Total")
    public Double getSubTotal (){
        return price*quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
