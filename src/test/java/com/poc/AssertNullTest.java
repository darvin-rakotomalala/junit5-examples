package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertNullTest {

    BookService bookService = new BookService();

    @Test
    public void assertNullWithNoMessage() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("4");
        assertNull(actualBook);
    }

    @Test
    public void assertNullWithMessage() {
        BookService bookService = new BookService();

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("4");
        assertNull(actualBook, "Book is not null !");
    }

    @Test
    public void assertNullWithMessageSupplier() {
        BookService bookService = new BookService();

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("4");
        assertNull(actualBook, () -> "Book is not null !");
    }
}
