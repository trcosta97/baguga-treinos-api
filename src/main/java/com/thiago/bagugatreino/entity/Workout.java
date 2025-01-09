package com.thiago.bagugatreino.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_workout")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_workout")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private LocalDateTime date;

    private LocalDateTime registerTime;

    private Boolean active;

    @OneToMany
    private List<Exercise> exercises;

    @PrePersist
    public void prePersist() {
        this.active = true;
        this.registerTime = LocalDateTime.now();
    }

    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }

}
