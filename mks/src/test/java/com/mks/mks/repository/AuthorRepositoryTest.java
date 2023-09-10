package com.mks.mks.repository;

import com.mks.mks.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void shouldReturnCountOfAuthors () {
        List<Author> all = authorRepository.findAll();
        assertEquals(2,all.size());
    }

    @Test
    void shouldReturnAuthorBySurname () {
        Author authorBySurname = authorRepository.findAuthorBySurname("Толстой");
        assertEquals("Лев", authorBySurname.getAuthorName());
    }
}