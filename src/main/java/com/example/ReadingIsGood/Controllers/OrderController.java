package com.example.ReadingIsGood.Controllers;

import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Models.Customer;
import com.example.ReadingIsGood.Models.Order;
import com.example.ReadingIsGood.Services.BookService;
import com.example.ReadingIsGood.Services.CustomerService;
import com.example.ReadingIsGood.Services.OrderService;
import com.example.ReadingIsGood.Validation.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingIsGood.Validation.Error;
import com.example.ReadingIsGood.Validation.OrderValidation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.websocket.server.PathParam;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {

    public final OrderService orderService;
    public final BookService bookService;
    public final CustomerService customerService;

    public OrderController(OrderService orderService, BookService bookService, CustomerService customerService) {
        this.orderService = orderService;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    @GetMapping
    @RequestMapping("/getAllOrders")
    public List<Order> fetchAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @RequestMapping("/addOrder")
    public Response addOrder(@RequestBody Order order) {
        OrderValidation validation = new OrderValidation();
        validation.validate(order);

        if (validation.failed()) {
            return Response.status(400).entity(new com.example.ReadingIsGood.Validation.Error(validation.errors().all()).toJson()).build();
        } else {
            try {
                List<String> bookIdList = order.getBooksId();
                Customer customer = customerService.getCustomerById(order.getCustomerId());
                
                if(customer == null){
                    return Response.status(400).entity(new Error(ErrorCode.CUSTOMER_INVALID).toJson()).build();
                }

                for (String bookId : bookIdList) {
                    Book book = bookService.getBookById(bookId);

                    if (book == null) {
                        return Response.status(400).entity(new Error(ErrorCode.BOOK_INVALID).toJson()).build();
                    }
                    orderService.saveOrder(order);

                    if (book.getStock() > 0) {
                        book.setStock(book.getStock() - 1);
                    } else {
                        return Response.status(400).entity(new Error(ErrorCode.STOCK_OUTOF).toJson()).build();
                    }
                    bookService.updateBook(book);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return Response.ok().build();
        }
    }

    @GetMapping
    @RequestMapping("/getOrderById")
    public Response getOrderById(@PathParam("id") String id) {
        Order order = orderService.getOrderById(id);

        if (order == null) {
            return Response.status(404).build();
        }
        return Response.ok(order).build();
    }

    @GetMapping
    @RequestMapping("/byDate")
    public Response getOrdersByStartDateBetween(@PathParam("StartDate") String StartDate, @PathParam("EndDate") String EndDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(StartDate);
        Date endDate = sdf.parse(EndDate);

        List<Order> orders = orderService.getOrdersByStartDateBetween(startDate, endDate);
        return Response.ok(orders).build();
    }

}
