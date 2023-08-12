package com.mks.mks.controllers;

import com.mks.mks.entity.Author;
import com.mks.mks.entity.Book;
import com.mks.mks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRESTController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<Author> getAuthors() {
        List<Author> authors = authorService.getAuthors();
        return authors;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping()
    public Author addNewAuthor(@RequestBody Author newAuthor) {
        authorService.saveAuthor(newAuthor);
        return newAuthor;
    }

    @PutMapping()
    public Author updateAuthor(@RequestBody Author updateAuthor) {
        authorService.saveAuthor(updateAuthor);
        return updateAuthor;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        authorService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void addBook(@PathVariable("id") int id, @RequestBody Book book) {
        Author author = null;
        if (authorService.getAuthorById(id) != null) {
            author = authorService.getAuthorById(id);
            author.addBook(book);
            authorService.saveAuthor(author);
        }
    }
}
