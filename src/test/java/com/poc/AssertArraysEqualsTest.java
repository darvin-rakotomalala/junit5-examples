package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AssertArraysEqualsTest {

    BookService bookService = new BookService();

    @Test
    public void assertArrayEqualsWithNoMessage() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");
        BookDTO headFirstJavascriptBook = new BookDTO("3", "Head First Javascript", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);

        String[] actualBookIds = bookService.getBookIdsByPublisher("Wrox");

        assertArrayEquals(new String[]{"1", "3"}, actualBookIds);
    }

    @Test
    public void assertArrayEqualsWithMessageSupplier() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        BookDTO headFirstDesignPatternBook = new BookDTO("2", "Head First Design Pattern", "Packt");
        BookDTO headFirstJavascriptBook = new BookDTO("3", "Head First Javascript", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);

        String[] actualBookIds = bookService.getBookIdsByPublisher("Wrox");

        assertArrayEquals(new String[]{"1", "3"}, actualBookIds, () -> "bookIds didnt match !");
    }

}
