package com.example.ReadingIsGood;

import com.example.ReadingIsGood.Controllers.BookController;
import com.example.ReadingIsGood.Models.Book;
import com.example.ReadingIsGood.Services.BookService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class BookControllerUnitTest {

    @Test
    void shouldAddBook() {
        BookService bookService = Mockito.mock(BookService.class);

        Book book = new Book(
                "Digital Castle",
                "Dan Brown",
                "Bilim Kurgu",
                "Odtu Yayıncılık",
                "2000",
                10.00,
                30  
        );
        book.setId("1");

        when(bookService.saveBook(book)).thenReturn(book);
        BookController bookController = new BookController(bookService);
        assertEquals(200, (bookController.addBook(book)).getStatus());
    }
}
