package com.poc;

import com.poc.dto.BookDTO;
import com.poc.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTest {

    BookService bookService = new BookService();

    @Test
    public void assertTrueWithMessage() {
        List<BookDTO> listOfBooks = bookService.books();
        assertTrue(listOfBooks.isEmpty(), "List of books is not empty !");
    }

    @Test
    public void assertTrueWithBooleanSupplierAndMessage() {
        List<BookDTO> listOfBooks = bookService.books();
        assertTrue(listOfBooks::isEmpty, "List of books is not empty!");
    }

    @Test
    public void assertTrueWithMessageSupplier() {
        List<BookDTO> listOfBooks = bookService.books();
        assertTrue(listOfBooks.isEmpty(), () -> "List of books is not empty!");
    }

    @Test
    public void assertTrueWithBooleanSupplierAndMessageSupplier() {
        BookDTO headFirstJavaBook = new BookDTO("1", "Head First Java", "Wrox");
        List<BookDTO> listOfBooks = bookService.books();
        assertTrue(listOfBooks::isEmpty, () -> "List of books is not empty!");
    }

}
