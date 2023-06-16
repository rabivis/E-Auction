package com.eAuction.eAuction.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(value = "USERS")
@CompoundIndex(name = "email_userType", def = "{'email':1,'userType':1}")
public class UsersDto {

    @Id
    private String userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String pin;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private  String userType;

}