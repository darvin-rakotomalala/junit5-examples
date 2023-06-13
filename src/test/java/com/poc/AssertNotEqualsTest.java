package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEqualsTest {

    BookService bookService = new BookService();

    @Test
    public void assertNotEqualsWithNoMessage() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertNotEquals("2", actualBook.getBookId());
    }

    @Test
    public void assertNotEqualsWithMessage() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertNotEquals("6", actualBook.getBookId(), "BookId matches to expected value!");
    }

    @Test
    public void assertNotEqualsWithMessageSupplier() {

        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        BookDTO actualBook = bookService.getBookById("1");

        assertNotEquals("5", actualBook.getBookId(), () -> "BookId matches to expected value!");
    }

}
