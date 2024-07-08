package com.ssil.sb3.graphql.h2.repository;

import com.ssil.sb3.graphql.h2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
