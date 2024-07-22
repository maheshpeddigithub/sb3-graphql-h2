package com.ssil.sb3.graphql.h2.controller;

import com.ssil.sb3.graphql.h2.model.Author;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @QueryMapping
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument Integer age) {
        Author author = Author.builder().name(name).age(age).build();
        authorRepository.save(author);
        return author;
    }


}
