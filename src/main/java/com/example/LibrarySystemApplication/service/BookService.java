package com.example.LibrarySystemApplication.service;

import com.example.LibrarySystemApplication.entity.Book;
import com.example.LibrarySystemApplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book registerBook(Book book)
    {
        List<Book> books = bookRepository.findByIsbn(book.getIsbn());
        if(books.isEmpty() || books.get(0).getTitle().equals(book.getTitle()) && books.get(0).getAuthor().equals(book.getAuthor()))
            return bookRepository.save(book);
        else
            throw new IllegalArgumentException("Book with this ISBN must have same title and author");
    }

    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public Book borrowBook(Long bookId)
    {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isEmpty())
            throw new IllegalArgumentException("Invalid book ID");

        if(book.get().isBorrowed())
        {
            throw new IllegalArgumentException("Book is already borrowed");
        }
        book.get().setBorrowed(true);
        return bookRepository.save(book.get());
    }

    public Book returnBook(Long bookId)
    {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isEmpty())
            throw  new IllegalArgumentException("Invalid book ID");

        if(!book.get().isBorrowed())
            throw new IllegalArgumentException("Book is not borrowed");

        book.get().setBorrowed(false);
        return bookRepository.save(book.get());
    }




}
