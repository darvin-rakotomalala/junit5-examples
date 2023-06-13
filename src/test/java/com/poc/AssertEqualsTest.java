package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsTest {

    BookService bookService = new BookService();

    @Test
    public void assertEqualsWithNoMessage() {
        BookService bookService = new BookService();

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertEquals("1", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle());
    }

    @Test
    public void assertEqualsWithMessage() {
        BookService bookService = new BookService();

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertEquals("1", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(), "Book title didnt match!");
    }

    @Test
    public void assertEqualsWithMessageSupplier() {
        BookService bookService = new BookService();

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertEquals("1", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(), () -> "Book title didnt match!");
    }

}
