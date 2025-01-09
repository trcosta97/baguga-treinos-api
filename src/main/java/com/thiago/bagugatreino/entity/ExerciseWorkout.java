package com.thiago.bagugatreino.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_exercise_workout")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exercise_workout")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private Double weight;

    private Integer repetitions;

    private Integer sets;
}

