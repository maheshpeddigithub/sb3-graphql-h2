package com.ssil.sb3.graphql.h2.service;

import com.ssil.sb3.graphql.h2.model.Author;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    private AuthorRepository authorRepository;
}
