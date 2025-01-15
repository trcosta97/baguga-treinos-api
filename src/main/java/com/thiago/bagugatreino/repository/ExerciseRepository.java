package com.thiago.bagugatreino.repository;

import com.thiago.bagugatreino.entity.Exercise;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

//    @Query("SELECT u FROM tb_exercise u")
//    List<Exercise> findAllWithSort(Sort sort);
}
