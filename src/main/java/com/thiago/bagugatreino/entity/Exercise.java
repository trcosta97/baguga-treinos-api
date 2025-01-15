package com.thiago.bagugatreino.entity;

import com.thiago.bagugatreino.dto.request.CreateExerciseRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_exercise")
@AllArgsConstructor
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

    public Exercise(){}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public MuscularGroup getMuscularGroup() {
        return muscularGroup;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setMuscularGroup(MuscularGroup muscularGroup) {
        this.muscularGroup = muscularGroup;
    }

    public Exercise(CreateExerciseRequestDto data) {
        this.name = data.name();
        this.description = data.desciption();
        this.image = data.desciption();
        this.muscularGroup = data.muscularGroup();
    }
}
