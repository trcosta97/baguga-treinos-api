package com.thiago.bagugatreino.controller;

import com.thiago.bagugatreino.dto.request.CreateUserRequestDto;
import com.thiago.bagugatreino.dto.response.CreateUserResponseDto;
import com.thiago.bagugatreino.dto.response.GetUserResponseDto;
import com.thiago.bagugatreino.entity.User;
import com.thiago.bagugatreino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponseDto> get(@PathVariable Long id){
        var user = service.get(id);
        var response = new GetUserResponseDto(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<GetUserResponseDto>> getAll(){
        var users = service.getAll();
        var response = new ArrayList<GetUserResponseDto>();

        for (User user : users) {
            response.add(new GetUserResponseDto(user));
        }
        return ResponseEntity.ok(response);


    }




}
