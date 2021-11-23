package com.example.ReadingIsGood.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Order {

    @Id
    private String id;
    private String customerId;
    private Date orderDate;
    private List<String> booksId;

    public Order(String customerId, Date orderDate, List<String> booksId) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.booksId = booksId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<String> getBooksId() {
        return booksId;
    }

    public void setBooksId(List<String> booksId) {
        this.booksId = booksId;
    }
}
