package com.ssil.sb3.graphql.h2.repository;

import com.ssil.sb3.graphql.h2.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
