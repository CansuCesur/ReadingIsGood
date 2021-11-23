package com.example.ReadingIsGood.Controllers;

import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Models.Order;
import com.example.ReadingIsGood.Models.Statistic;
import com.example.ReadingIsGood.Services.BookService;
import com.example.ReadingIsGood.Services.CustomerService;
import com.example.ReadingIsGood.Services.OrderService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final CustomerService customerService;
    private final OrderService orderService;
    private final BookService bookService;

    public StatisticController(CustomerService customerService, OrderService orderService, BookService bookService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping
    @RequestMapping("/getStatisticByCustomerId")
    public List<Statistic> getStatisticByCustomerId(@PathParam("id") String id, @PathParam("year") int year) {
        List<Statistic> statistics = new ArrayList<Statistic>();
        List<Order> orders = orderService.getOrdersByCustomerId(id);

        //loop for months
        for (int i = 1; i <= 12; i++) {

            Statistic statistic = new Statistic(i, 0, 0, 0);
            int totalOrderCount = 0;
            int totalBookCount = 0;
            double totalPurchasedAmount = 0;
            
            //loop for orders
            for (int j = 0; j < orders.size(); j++) {
                Date orderDate = orders.get(j).getOrderDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(orderDate);
                int monthOfOrder = cal.get(Calendar.MONTH) + 1;
                int yearOfOrder = cal.get(Calendar.YEAR);
                
                if (monthOfOrder == i && yearOfOrder == year) {
                    List<String> orderedBooksId = orders.get(j).getBooksId();
                    totalOrderCount++;
                    totalBookCount = totalBookCount + orderedBooksId.size();

                    for (int k = 0; k < orderedBooksId.size(); k++) {
                        Book book = bookService.getBookById(orderedBooksId.get(k));
                        totalPurchasedAmount = totalPurchasedAmount + book.getPrice();
                        statistic.setMonth(i);
                        statistic.setTotalOrderCount(totalOrderCount);
                        statistic.setTotalBookCount(totalBookCount);
                        statistic.setTotalPurchasedAmount(totalPurchasedAmount);
                    }
                }
            }
            statistics.add(statistic);
        }
        return statistics;

    }

}
