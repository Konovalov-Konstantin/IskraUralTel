package com.mks.mks.repository;

import com.mks.mks.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void shouldReturnCountOfBooks() {
        List<Book> books = bookRepository.findAll();
        assertEquals(2, books.size());
    }

    @Test
    void shouldReturnBookByTitle() {
        Book bookByTitle = bookRepository.findBookByTitle("Последний из могикан");
        assertEquals("Джеймс", bookByTitle.getAuthor().getAuthorName());
        assertEquals("Купер", bookByTitle.getAuthor().getSurname());
    }

}