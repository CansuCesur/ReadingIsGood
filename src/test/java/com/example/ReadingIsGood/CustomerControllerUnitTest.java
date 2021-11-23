package com.example.ReadingIsGood;

import com.example.ReadingIsGood.Controllers.CustomerController;
import com.example.ReadingIsGood.Models.Address;
import com.example.ReadingIsGood.Models.Customer;
import com.example.ReadingIsGood.Models.Gender;
import com.example.ReadingIsGood.Services.CustomerService;
import com.example.ReadingIsGood.Services.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class CustomerControllerUnitTest {

    @Test
    void shouldAddCustomer() {
        CustomerService customerService = Mockito.mock(CustomerService.class);
        OrderService orderService = Mockito.mock(OrderService.class);

        Address address = new Address(
                "Turkey",
                "Izmir",
                "Bornova",
                "Atatürk mah. 994 sk. No:30 d:1 Bornova/İzmir",
                "35030"
        );
        Customer customer = new Customer(
                "Jamila",
                "Ahmed",
                "cansuces",
                "password",
                "cansucesur96@gmail.com",
                Gender.FEMALE,
                address,
                List.of("Computer Sicence", "Math"),
                LocalDateTime.now()
        );
        customer.setId("1");
        when(customerService.saveCustomer(customer)).thenReturn(customer);
        CustomerController customerController = new CustomerController(customerService, orderService);
        assertEquals(200, (customerController.addCustomer(customer)).getStatus());
    }
}
