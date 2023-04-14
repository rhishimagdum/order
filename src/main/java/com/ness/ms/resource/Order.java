package com.ness.ms.resource;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    Long userId;
    LocalDate orderDate;
    Double totalPrice;
    String status;
    @OneToMany(mappedBy = "orderOfItem", cascade = CascadeType.ALL)
    List<Item> items;

    public Order() {
    }

    public Order(Long orderId, Long userId, LocalDate orderDate, Double totalPrice, String status) {
        this.id = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        items.forEach(item -> item.setOrderOfItem(this));
    }

    public void addItems(Item item) {
        items.add(item);
        item.setOrderOfItem(this);
    }
}
