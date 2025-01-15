package com.thiago.bagugatreino.service;

import com.thiago.bagugatreino.entity.Exercise;
import com.thiago.bagugatreino.repository.ExerciseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {


    @Autowired
    ExerciseRepository repository;

    public Exercise create(Exercise exercise){
        return repository.save(exercise);
    }

    public List<Exercise> getAll(String param, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, param);
        return repository.findAll(sort);
    }

    public Exercise findById(Long id){
        Optional<Exercise> optionalExercise = repository.findById(id);
        return optionalExercise.orElse(null);
    }

}
