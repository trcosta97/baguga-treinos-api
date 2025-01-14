package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateUserRequestDto;
import com.thiago.bagugatreino.dto.response.CreateUserResponseDto;
import com.thiago.bagugatreino.entity.User;
import com.thiago.bagugatreino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;




}
