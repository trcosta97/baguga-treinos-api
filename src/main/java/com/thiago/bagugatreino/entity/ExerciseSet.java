package com.thiago.bagugatreino.entity;


import com.thiago.bagugatreino.dto.request.CreateExerciseSetRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_exercise_set")
@AllArgsConstructor
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ExerciseSetId")
    private Long id;
    private Integer repetitions;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "workoutId")
    private Workout workout;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private LocalDateTime registerTime;

    public ExerciseSet(){}

    public Long getId() {
        return id;
    }
    public Integer getRepetitions() {
        return repetitions;
    }
    public Double getWeight() {
        return weight;
    }
    public Exercise getExercise() {
        return exercise;
    }
    public Workout getWorkout() {
        return workout;
    }
    public LocalDateTime getRegisterTime() {
        return registerTime;
    }
    public User getUser(){return this.user; }

    public void setUser(User user){ this.user = user; }
    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public ExerciseSet(CreateExerciseSetRequestDto data) {
        this.repetitions = data.repetitions();
        this.weight = data.weight();
        this.registerTime = LocalDateTime.now(); // Set register time here
    }


}
