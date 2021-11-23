package com.example.ReadingIsGood.Services;

import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.insert(book);
    }

    public Book getBookById(String id) {
        return bookRepository.findBookById(id);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

}
