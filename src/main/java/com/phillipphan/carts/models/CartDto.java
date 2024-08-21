package com.phillipphan.carts.models;

import jakarta.validation.constraints.*;
 
public class CartDto {
    @NotEmpty(message = "A Cart Number is required")
    private String cartNumber;

    @NotEmpty(message = "The building name is required")
    private String building;

    @NotEmpty(message = "The name is required")
    private String eid;

    @Size(min = 10, message = "Phone number must be 10 digits")
    @Size(max = 10, message = "Phone number must be 10 digits")
    private String phone;
    
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    private String description;

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
}
