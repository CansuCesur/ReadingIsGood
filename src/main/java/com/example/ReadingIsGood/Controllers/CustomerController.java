package com.example.ReadingIsGood.Controllers;

import com.example.ReadingIsGood.Models.Customer;
import com.example.ReadingIsGood.Models.Order;
import com.example.ReadingIsGood.Services.CustomerService;
import com.example.ReadingIsGood.Services.OrderService;
import com.example.ReadingIsGood.Validation.CustomerValidation;
import com.example.ReadingIsGood.Validation.Error;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping
    @RequestMapping("/getAllCustomers")
    public List<Customer> fetchAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    @RequestMapping("/addCustomer")
    public Response addCustomer(@RequestBody Customer customer) {
        CustomerValidation validation = new CustomerValidation();
        validation.validate(customer);
        if (validation.failed()) {
            return Response.status(400).entity(new Error(validation.errors().all()).toJson()).build();
        } else {
            customerService.saveCustomer(customer);
            return Response.ok().build();
        }
    }

    @GetMapping
    @RequestMapping("/getCustomerById")
    public Response getCustomerById(@PathParam("id") String id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer == null) {
            return Response.status(404).build();
        }
        return Response.ok(customer).build();
    }

    @GetMapping
    @RequestMapping("/getOrdersByCustomerId")
    public Response getOrdersByCustomerId(@PathParam("id") String id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer == null) {
            return Response.status(404).build();
        }

        List<Order> orders = orderService.getOrdersByCustomerId(id);
        return Response.ok(orders).build();
    }

}
