package com.poc.service;

import com.poc.dto.BookDTO;
import com.poc.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {

    private List<BookDTO> listOfBooks = new ArrayList<>();

    public void addBook(BookDTO book) {
        listOfBooks.add(book);
    }

    public List<BookDTO> books() {
        return Collections.unmodifiableList(listOfBooks);
    }

    public BookDTO getBookById(String bookId) {
        for (BookDTO book : listOfBooks) {
            if (bookId.equals(book.getBookId())) {
                return book;
            }
        }
        return null;
    }

    public String[] getBookIdsByPublisher(String publisher) {
        List<String> bookIds = new ArrayList<>();
        for (BookDTO book : listOfBooks) {
            if (publisher.equals(book.getPublisher())) {
                bookIds.add(book.getBookId());
            }
        }
        return bookIds.toArray(new String[bookIds.size()]);
    }

    public List<String> getBookTitlesByPublisher(String publisher) {
        List<String> bookTitles = new ArrayList<>();
        for (BookDTO book : listOfBooks) {
            if (publisher.equals(book.getPublisher())) {
                bookTitles.add(book.getTitle());
            }
        }
        return bookTitles;
    }

    public BookDTO getBookByTitle(String title) {
        for (BookDTO book : listOfBooks) {
            if (title.equals(book.getTitle())) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found in Bookstore!");
    }

}
