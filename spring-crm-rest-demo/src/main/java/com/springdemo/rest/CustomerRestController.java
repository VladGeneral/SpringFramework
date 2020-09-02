package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            throw new CustomerNotFoundException("Customer not found - " + customerId);
        }
        return customer;
    }

    //add mapping for Post /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        //also just in case the pass an id in JSON set id to 0
        //this is force a save of new item
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }
}
