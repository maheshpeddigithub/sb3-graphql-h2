package com.ssil.sb3.graphql.h2.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ssil.sb3.graphql.h2.model.Author;
import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import com.ssil.sb3.graphql.h2.repository.TutorialRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;

	public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
	}

	public long countAuthors() {
		return authorRepository.count();
	}

	public long countTutorials() {
		return tutorialRepository.count();
	}

}
