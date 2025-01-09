package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
