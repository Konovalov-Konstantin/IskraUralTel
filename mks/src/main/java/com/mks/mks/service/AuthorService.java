package com.mks.mks.service;

import com.mks.mks.entity.Author;
import com.mks.mks.entity.Book;
import com.mks.mks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteById(int id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        }
    }

    public Optional<Author> getAuthorBySurname(String surname) {
        return Optional.ofNullable(authorRepository.findAuthorBySurname(surname));
    }

    public void addBook (Author author, Book boook) {
        author.addBook(boook);
    }
}
