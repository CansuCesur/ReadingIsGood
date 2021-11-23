package com.example.ReadingIsGood.Repositories;

import com.example.ReadingIsGood.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findBookById(String id);
}
