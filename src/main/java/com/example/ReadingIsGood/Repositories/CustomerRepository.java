package com.example.ReadingIsGood.Repositories;

import com.example.ReadingIsGood.Models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findCustomerById(String id);
}
