package com.nadaabuissa.Inventory_Management_System_Rest_APIs.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_involved_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_affected_ID")
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "address_ID")
    private Address address;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}