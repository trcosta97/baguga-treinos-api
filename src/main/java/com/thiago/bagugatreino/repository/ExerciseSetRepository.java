package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.entity.ExerciseSet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ExerciseSetRepository extends JpaRepository<ExerciseSet,Long> {


}
