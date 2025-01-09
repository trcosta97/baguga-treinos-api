package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
