package com.ness.ms.resource;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    @JsonBackReference
    Order orderOfItem;
    Long quantity;
    Double pricePerUnit;

    public Item() {
    }

    public Item(Order orderOfItem, Long quantity, Double pricePerUnit) {
        this.orderOfItem = orderOfItem;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrderOfItem() {
        return orderOfItem;
    }

    public void setOrderOfItem(Order orderOfItem) {
        this.orderOfItem = orderOfItem;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
