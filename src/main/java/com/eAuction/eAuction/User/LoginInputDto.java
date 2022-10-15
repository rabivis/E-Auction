package com.eAuction.eAuction.User;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginInputDto {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
