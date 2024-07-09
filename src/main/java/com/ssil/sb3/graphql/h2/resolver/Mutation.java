package com.ssil.sb3.graphql.h2.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ssil.sb3.graphql.h2.model.Author;
import com.ssil.sb3.graphql.h2.model.Tutorial;
import com.ssil.sb3.graphql.h2.repository.AuthorRepository;
import com.ssil.sb3.graphql.h2.repository.TutorialRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;

	public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
	}

	public Author createAuthor(String name, Integer age) {
		Author author = Author.builder().name(name).age(age).build();
		authorRepository.save(author);
		return author;
	}

	public Tutorial createTutorial(String title, String description, Long authorId) {
		Tutorial tutorial = Tutorial.builder().author(new Author(authorId)).title(title).description(description).build();
		tutorialRepository.save(tutorial);
		return tutorial;
	}

	public boolean deleteTutorial(Long id) {
		tutorialRepository.deleteById(id);
		return true;
	}

	public Tutorial updateTutorial(Long id, String title, String description) throws ChangeSetPersister.NotFoundException {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

		if (optTutorial.isPresent()) {
			Tutorial tutorial = optTutorial.get();

			if (title != null)
				tutorial.setTitle(title);
			if (description != null)
				tutorial.setDescription(description);

			tutorialRepository.save(tutorial);
			return tutorial;
		}

		throw new ChangeSetPersister.NotFoundException();
	}
}
