package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ExerciseSetRepository extends JpaRepository<ExerciseSet,Long> {

    @Query("SELECT es FROM ExerciseSet es WHERE es.exercise.id = :exerciseId AND es.user.id = :userId")
    List<ExerciseSet> getByExerciseIdAndUserId(Long exerciseId, Long userId);
}
