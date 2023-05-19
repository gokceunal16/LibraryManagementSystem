package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public void createAuthor(Author author) {
        authorRepository.createAuthor(author);
    }

    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    public Author findById(int id) {
        return authorRepository.findById(id);
    }

    public void updateAuthor(int id, Author author) {
        authorRepository.updateAuthor(id, author);
    }
}
