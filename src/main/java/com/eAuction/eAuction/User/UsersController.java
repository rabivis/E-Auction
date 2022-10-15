package com.eAuction.eAuction.User;


import com.eAuction.eAuction.seller.AddProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/api/v1/user/")
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public String register( @Valid @RequestBody RegisterInputDto user){
        return userService.CreateUser(user);
    }

    @CrossOrigin
    @PostMapping("login")
    public LoginResponse login(@Valid @RequestBody LoginInputDto login){
        return userService.LoginUser(login);
    }
}
