package com.eAuction.eAuction.model;

import com.eAuction.eAuction.dao.UsersDto;
import lombok.Data;

@Data
public class LoginResponse {
    private UsersDto user;
    private String token;
}
