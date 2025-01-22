package com.thiago.bagugatreino.entity;

import com.thiago.bagugatreino.dto.request.CreateUserRequestDto;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "tb_user")
@Entity(name = "tb_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private String gender;
    private UserRole role;
    private LocalDateTime registerTime;
    private Boolean active;

    public User(){}



    public User(String email, String password, UserRole role, String name, LocalDate birthday, String gender){
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
