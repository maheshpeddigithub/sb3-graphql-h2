package com.ssil.sb3.graphql.h2.controller;

import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import com.ssil.sb3.graphql.h2.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TutorialController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TutorialRepository tutorialRepository;

    @QueryMapping
    public List<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    @MutationMapping
    public Tutorial createTutorial(@Argument String title, @Argument String description, @Argument Integer author) {
        Tutorial tutorial = Tutorial.builder().title(title).description(description).author(authorRepository.findById(Long.valueOf(author)).orElse(null)).build();
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    @MutationMapping
    public Tutorial updateTutorial(@Argument Integer id, @Argument String title, @Argument String description) {
        Tutorial tutorial = tutorialRepository.findById(Long.valueOf(id)).orElse(null);
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    @MutationMapping
    public Boolean deleteTutorial(@Argument Integer id) {
        tutorialRepository.deleteById(Long.valueOf(id));
        return true;
    }

}
