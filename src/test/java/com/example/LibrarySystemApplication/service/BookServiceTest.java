package com.example.LibrarySystemApplication.service;

import com.example.LibrarySystemApplication.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testRegisterBook(){
        Book book = new Book();
        book.setIsbn("123-456-789");
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        Book savedBook = bookService.registerBook(book);
    }
}
