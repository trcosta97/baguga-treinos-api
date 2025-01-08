package com.thiago.bagugatreino.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_exercise")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exercise")
    private Long id;

    private String name;

    private String description;

    private String image;

    @Column(name = "muscular_group")
    @Enumerated(EnumType.STRING)
    private MuscularGroup muscularGroup;

}
