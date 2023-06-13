package com.poc;

import com.poc.dto.BookDTO;
import com.poc.exception.BookNotFoundException;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsTest {

    BookService bookService = new BookService();

    @Test
    public void assertThrowsWithNoMessage() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookNotFoundException bookNotFoundException = assertThrows(BookNotFoundException.class,
                () -> bookService.getBookByTitle("Head First Spring"));

        assertEquals("Book not found in Bookstore!", bookNotFoundException.getMessage());
    }

    @Test
    public void assertThrowsWithMessage() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        assertThrows(BookNotFoundException.class,
                () -> bookService.getBookByTitle("Head First Spring"),
                "Different exception thrown!");
    }

    @Test
    public void assertThrowsWithMessageSupplier() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        assertThrows(BookNotFoundException.class,
                () -> bookService.getBookByTitle("Head First Spring"),
                () -> "Different exception thrown!");
    }

}
