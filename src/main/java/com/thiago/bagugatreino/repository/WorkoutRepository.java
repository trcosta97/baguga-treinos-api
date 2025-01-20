package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    List<Workout> findByUserId(Long userId);
}
