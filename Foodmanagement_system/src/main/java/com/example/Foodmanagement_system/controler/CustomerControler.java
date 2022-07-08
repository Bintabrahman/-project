package com.example.Foodmanagement_system.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Foodmanagement_system.exception.ResourceNotFoundException;
import com.example.Foodmanagement_system.model.Customer;
import com.example.Foodmanagement_system.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/customers")
public class CustomerControler {
    @Autowired
    private CustomerRepository customerRepository;


    //get All Customer
    @GetMapping("/")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    //post to Customer Table
    @PostMapping("/")
    public Customer AddCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    
    
    //update customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer)
    {
        Customer cmt = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        cmt.setFullname(customer.getFullname());
        cmt.setStreet_adress(customer.getStreet_adress());
        cmt.setPhone_number(customer.getPhone_number());
        cmt.setEmail(customer.getEmail());
        cmt.setDelivery_area(customer.getDelivery_area());
        cmt.setItems(customer.getItems());

        
        Customer cmt2 = customerRepository.save(cmt);
        return ResponseEntity.ok(cmt2);
    }


    //get customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id)
    {
        Customer cmt = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        return ResponseEntity.ok(cmt);
    }



    //delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable long id)
    {
        Customer cmt = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        customerRepository.delete(cmt);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    
}
