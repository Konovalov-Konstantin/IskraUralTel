package com.mks.mks.controllers;

import com.mks.mks.entity.Book;
import com.mks.mks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRESTController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getBooks() {
        List<Book> books = bookService.getBooks();
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }
}
