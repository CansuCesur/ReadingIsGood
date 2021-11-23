package com.example.ReadingIsGood.Services;

import com.example.ReadingIsGood.Models.Customer;
import com.example.ReadingIsGood.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.insert(customer);

    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}
