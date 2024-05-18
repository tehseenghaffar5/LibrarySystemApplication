package com.example.LibrarySystemApplication.controller;

import com.example.LibrarySystemApplication.entity.Book;
import com.example.LibrarySystemApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody Book book)
    {
        Book newBook = bookService.registerBook(book);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/{bookId}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId)
    {
        Book borrowBook = bookService.borrowBook(bookId);
        return ResponseEntity.ok(borrowBook);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId)
    {
        Book returnBook = bookService.returnBook(bookId);
        return ResponseEntity.ok(returnBook);

    }


}
