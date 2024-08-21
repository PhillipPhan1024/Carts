package com.phillipphan.carts.models;

import jakarta.persistence.*;

@Entity
@Table(name="carts")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cartNumber;
    private String building;
    private String eid;
    private String phone;

    @Column(columnDefinition="TEXT")
    private String description;
    private String createdAt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCartNumber() {
        return cartNumber;
    }
    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }
    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public String getEid() {
        return eid;
    }
    public void setEid(String eid) {
        this.eid = eid;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
