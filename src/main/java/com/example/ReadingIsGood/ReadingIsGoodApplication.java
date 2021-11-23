package com.example.ReadingIsGood;

import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Models.Order;
import com.example.ReadingIsGood.Models.Gender;
import com.example.ReadingIsGood.Models.Customer;
import com.example.ReadingIsGood.Models.Address;
import com.example.ReadingIsGood.Repositories.BookRepository;
import com.example.ReadingIsGood.Repositories.CustomerRepository;
import com.example.ReadingIsGood.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class ReadingIsGoodApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReadingIsGoodApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        //Clean repositories
        customerRepository.deleteAll();
        bookRepository.deleteAll();
        orderRepository.deleteAll();

        //Add data to repositories
        Address address1 = new Address(
                "Turkey",
                "Izmir",
                "Bornova",
                "Atatürk mah. 994 sk. No:30 d:1 Bornova/İzmir",
                "35030"
        );
        Address address2 = new Address(
                "Turkey",
                "Izmir",
                "Alsancak",
                "Koru mah. 994 sk. No:30 d:1 Bornova/İzmir",
                "35020"
        );

        Customer customer1 = new Customer(
                "Seray",
                "Güderel",
                "seroli",
                "12345",
                "serayguderel@gmail.com",
                Gender.FEMALE,
                address1,
                List.of("Bilim Kurgu", "Fantastik"),
                LocalDateTime.now()
        );
        customer1.setId("1");

        Customer customer2 = new Customer(
                "Ahmet",
                "Köse",
                "akose",
                "12345",
                "ahmetkose@gmail.com",
                Gender.MALE,
                address2,
                List.of("Dil", "Bilim"),
                LocalDateTime.now()
        );
        customer2.setId("2");

        Customer customer3 = new Customer(
                "Eylül",
                "Ece",
                "eylulece",
                "12345",
                "eylulece@gmail.com",
                Gender.FEMALE,
                address1,
                List.of("Fantastik", "Bilim"),
                LocalDateTime.now()
        );
        customer3.setId("3");

        customerRepository.insert(customer1);
        customerRepository.insert(customer2);
        customerRepository.insert(customer3);

        Book book1 = new Book(
                "Digital Castle",
                "Dan Brown",
                "Bilim Kurgu",
                "Odtu Yayıncılık",
                "2000",
                30.00,
                30
        );
        book1.setId("1");

        Book book2 = new Book(
                "Serenad",
                "Zülfü Livaneli",
                "Roman",
                "Doğan Kitap",
                "2003",
                45.00,
                50
        );
        book2.setId("2");

        Book book3 = new Book(
                "Dönüşüm",
                "Franz Kafka",
                "Roman",
                "Demetler Yayınevi",
                "2005",
                25.00,
                10
        );
        book3.setId("3");

        bookRepository.insert(book1);
        bookRepository.insert(book2);
        bookRepository.insert(book3);

        Date date1 = new GregorianCalendar(2021, Calendar.JANUARY, 10).getTime();
        Date date2 = new GregorianCalendar(2021, Calendar.MARCH, 11).getTime();
        Date date3 = new GregorianCalendar(2021, Calendar.APRIL, 11).getTime();
        Date date4 = new GregorianCalendar(2021, Calendar.AUGUST, 11).getTime();
        Date date5 = new GregorianCalendar(2020, Calendar.JANUARY, 10).getTime();
        Date date6 = new GregorianCalendar(2020, Calendar.OCTOBER, 11).getTime();

        Order order1 = new Order(
                "1",
                date1,
                List.of("1","2")
        );
        order1.setId("1");

        Order order2 = new Order(
                "1",
                date2,
                List.of("1","3")
        );
        order2.setId("2");

        Order order3 = new Order(
                "1",
                date3,
                List.of("3")
        );
        order3.setId("3");

        Order order4 = new Order(
                "1",
                date4,
                List.of("2","3")
        );
        order4.setId("4");

        Order order5 = new Order(
                "1",
                date5,
                List.of("1","2","3")
        );
        order5.setId("5");

        Order order6 = new Order(
                "1",
                date6,
                List.of("1")
        );
        order6.setId("6");

        Order order7 = new Order(
                "2",
                date1,
                List.of("1")
        );
        order7.setId("7");

        Order order8 = new Order(
                "3",
                date2,
                List.of("1","2")
        );
        order8.setId("8");

        Order order9 = new Order(
                "3",
                date3,
                List.of("3")
        );
        order9.setId("9");

        orderRepository.insert(order1);
        orderRepository.insert(order2);
        orderRepository.insert(order3);
        orderRepository.insert(order4);
        orderRepository.insert(order5);
        orderRepository.insert(order6);
        orderRepository.insert(order7);
        orderRepository.insert(order8);
        orderRepository.insert(order9);

    }

    //Encode password for validation
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
