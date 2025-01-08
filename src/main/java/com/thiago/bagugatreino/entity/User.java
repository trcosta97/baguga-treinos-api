package com.thiago.bagugatreino.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tb_user")
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String email;
    private LocalDateTime birthday;
    private Character gender;
    private LocalDateTime registerTime;
    private Boolean active;

    @PrePersist
    public void prePersist(){
        this.active = true;
        this.registerTime = LocalDateTime.now();
    }

}
