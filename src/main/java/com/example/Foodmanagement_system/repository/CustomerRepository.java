package com.example.Foodmanagement_system.repository;

import com.example.Foodmanagement_system.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
}
