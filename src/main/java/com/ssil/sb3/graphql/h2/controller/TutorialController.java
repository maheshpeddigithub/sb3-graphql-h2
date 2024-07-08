package com.ssil.sb3.graphql.h2.controller;

import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {

    public TutorialController(TutorialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getTutorials() {
        return new ResponseEntity<>(service.getTutorials(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        return new ResponseEntity<>(service.createTutorial(tutorial), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTutorial(@PathVariable Long id) {
        service.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private TutorialService service;
}
