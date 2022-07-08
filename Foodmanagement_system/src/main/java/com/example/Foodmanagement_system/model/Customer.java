package com.example.Foodmanagement_system.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "street_adress")
    private String street_adress;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;
    @Column(name = "delivery_area")
    private String delivery_area;
    @Column(name = "items")
    private String items;

    public Customer(){

    }

    public Customer(long id,String fullname,String street_adress,String phone_number,String email,String delivery_area,String items){
        this.id = id;
        this.fullname = fullname;
        this.street_adress = street_adress;
        this.phone_number = phone_number;
        this.email = email;
        this. delivery_area = delivery_area;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStreet_adress() {
        return street_adress;
    }

    public void setStreet_adress(String street_adress) {
        this.street_adress = street_adress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDelivery_area() {
        return delivery_area;
    }

    public void setDelivery_area(String delivery_area) {
        this.delivery_area = delivery_area;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
    
    
}
