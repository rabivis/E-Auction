package com.eAuction.eAuction.controller;


import com.eAuction.eAuction.exception.InputValidateException;
import com.eAuction.eAuction.model.LoginInputDto;
import com.eAuction.eAuction.model.LoginResponse;
import com.eAuction.eAuction.model.RegisterInputDto;
import com.eAuction.eAuction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/api/v1/user/")
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterInputDto user){
        try {
            String response = userService.CreateUser(user);
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (InputValidateException e){
            System.out.println("Error: "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin
    @PostMapping("login")
    public LoginResponse login(@Valid @RequestBody LoginInputDto login){
        return userService.LoginUser(login);
    }
}
