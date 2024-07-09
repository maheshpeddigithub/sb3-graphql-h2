package com.ssil.sb3.graphql.h2.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ssil.sb3.graphql.h2.model.Author;
import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
	@Autowired
	private AuthorRepository authorRepository;

	public TutorialResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Tutorial tutorial) {
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
}
