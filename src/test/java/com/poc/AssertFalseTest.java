package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertFalseTest {

    BookService bookService = new BookService();

    @Test
    public void assertFalseWithMessage() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<BookDTO> listOfBooks = bookService.books();
        assertFalse(listOfBooks.isEmpty(), "List of books is empty !");
    }

    @Test
    public void assertFalseWithBooleanSupplierAndMessage() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<BookDTO> listOfBooks = bookService.books();
        assertFalse(listOfBooks::isEmpty, "List of books is not empty !");
    }

    @Test
    public void assertFalseWithMessageSupplier() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<BookDTO> listOfBooks = bookService.books();
        assertFalse(listOfBooks.isEmpty(), () -> "List of books is empty !");
    }

    @Test
    public void assertFalseWithBooleanSupplierAndMessageSupplier() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<BookDTO> listOfBooks = bookService.books();
        assertFalse(listOfBooks::isEmpty, () -> "List of books is empty!");
    }

}
