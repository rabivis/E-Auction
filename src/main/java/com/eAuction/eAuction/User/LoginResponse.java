package com.eAuction.eAuction.User;

import com.eAuction.eAuction.dao.UsersDto;
import lombok.Data;

@Data
public class LoginResponse {
    private UsersDto user;
    private String token;
}
