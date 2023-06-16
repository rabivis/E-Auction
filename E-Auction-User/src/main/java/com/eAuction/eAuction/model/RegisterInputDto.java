package com.eAuction.eAuction.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterInputDto {

    @NotBlank(message = "First Name is required")
    @Size(min = 3, max = 30, message = "The length of first name must be between 5 to 30 character")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(min = 3, max = 25, message = "The length of last name must be between 3 to 25 character")
    private String lastName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Pin is required")
    private String pin;

    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 10, message = "The length of phone must be between 10 to 10 character")
    private String phone;

    @NotBlank(message = "Phone is required")
    @Email(message = "Enter Valid email id")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 10, message = "The length of password must be between 6 to 10 character")
    private String password;

    @NotBlank(message = "User type is required")
    private  String userType;
}
