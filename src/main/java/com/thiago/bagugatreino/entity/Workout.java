package com.thiago.bagugatreino.entity;

import com.thiago.bagugatreino.dto.request.CreateWorkoutRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_workout")
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_workout")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private LocalDateTime registerTime;

    private Boolean active;

    @OneToMany
    private List<Exercise> exercises = new ArrayList<>();
    @OneToMany(mappedBy = "workout")
    private List<ExerciseSet> exerciseSets = new ArrayList<>();

    public Workout (){}

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public String getName() {
        return name;
    }
    public Boolean getActive() {
        return active;
    }
    public List<Exercise> getExercises() {
        return exercises;
    }
    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }
    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Workout(CreateWorkoutRequestDto data) {
        this.name = data.name();
        this.registerTime = LocalDateTime.now(); // Automatically set the registration time
        this.active = true;
    }

    @PrePersist
    public void prePersist() {
        this.active = true;
        this.registerTime = LocalDateTime.now();
    }

    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }

}
