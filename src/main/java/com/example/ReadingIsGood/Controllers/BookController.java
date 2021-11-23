package com.example.ReadingIsGood.Controllers;

import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Services.BookService;
import com.example.ReadingIsGood.Validation.BookValidation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @RequestMapping("/getAllBooks")
    public List<Book> fetchAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @RequestMapping("/addBook")
    public Response addBook(@RequestBody Book book) {
        BookValidation validation = new BookValidation();
        validation.validate(book);
        if (validation.failed()) {
            return Response.status(400).entity(new com.example.ReadingIsGood.Validation.Error(validation.errors().all()).toJson()).build();
        } else {
            bookService.saveBook(book);
            return Response.ok().build();
        }
    }

    @GetMapping
    @RequestMapping("/getBookById")
    public Response getCustomerById(@PathParam("id") String id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return Response.status(404).build();
        }
        return Response.ok(book).build();
    }

    @PostMapping
    @RequestMapping("/stockUpdate")
    public Response getOrdersByCustomerId(@PathParam("id") String id, @PathParam("stock") int stock) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return Response.status(404).build();
        }
        book.setStock(stock);
        bookService.updateBook(book);
        return Response.ok(book).build();
    }

    @GetMapping
    @RequestMapping("/getStock")
    public Response getStock(@PathParam("id") String id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return Response.status(404).build();
        }
        return Response.ok(book.getStock()).build();
    }

}
