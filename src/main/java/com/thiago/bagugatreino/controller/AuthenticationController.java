package com.thiago.bagugatreino.controller;


import com.thiago.bagugatreino.dto.request.CreateUserRequestDto;
import com.thiago.bagugatreino.dto.response.LoginResponseDto;
import com.thiago.bagugatreino.entity.AuthenticationDto;
import com.thiago.bagugatreino.entity.User;
import com.thiago.bagugatreino.infra.security.TokenService;
import com.thiago.bagugatreino.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var userId = repository.getIdByEmail(data.email());
        var token = tokenService.generateToken((User) auth.getPrincipal());
        var response = new LoginResponseDto(token, userId);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CreateUserRequestDto data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword, data.role(), data.name(), data.birthday(), data.gender());
        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
