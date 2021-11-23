package com.example.ReadingIsGood.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {

    @Id
    private String id;
    private String tittle;
    private String author;
    private String subject;
    private String publisher;
    private String publishDate;
    private double price;
    private int stock;
 

    public Book(String tittle, String author,String subject, String publisher, String publishDate, double price, int stock) {
        this.tittle = tittle;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.stock = stock;
    }
    

}
