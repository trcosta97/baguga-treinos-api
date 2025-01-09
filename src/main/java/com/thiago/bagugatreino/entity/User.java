package com.thiago.bagugatreino.entity;

import com.thiago.bagugatreino.dto.CreateUserDto;
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
    private String password;
    private LocalDateTime birthday;
    private Character gender;
    private LocalDateTime registerTime;
    private Boolean active;

    public User(CreateUserDto data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.birthday = data.birthday();
        this.gender = data.gender();
    }

    public Long getId(){
        return this.id;
    }

    @PrePersist
    public void prePersist(){
        this.active = true;
        this.registerTime = LocalDateTime.now();
    }

}
