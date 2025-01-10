package com.thiago.bagugatreino.entity;

import com.thiago.bagugatreino.dto.CreateUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "tb_user")
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private String gender;
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @PrePersist
    public void prePersist(){
        this.active = true;
        this.registerTime = LocalDateTime.now();
    }

}
