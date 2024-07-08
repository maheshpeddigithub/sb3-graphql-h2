package com.ssil.sb3.graphql.h2.service;

import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public Tutorial createTutorial(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    public List<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }

    public void deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }

    private TutorialRepository tutorialRepository;
}
