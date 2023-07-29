package com.years.deals.controller;

import com.years.deals.Country;
import com.years.deals.CountryRepository;
import com.years.deals.Customer;
import com.years.deals.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    private CountryRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/hello")
    String message() {
        return "Say Hello";
    }

    @GetMapping("/countries")
    Collection<Country> getAllCountries() {
        return repository.findAll();
    }

    @GetMapping("/users")
    Collection<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @PostMapping("/users")
    Customer getAllUsers(@RequestBody Customer user) {
        return customerRepository.save(user);
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        return new ResponseEntity<>(repository.save(country), HttpStatus.CREATED);
    }
}
