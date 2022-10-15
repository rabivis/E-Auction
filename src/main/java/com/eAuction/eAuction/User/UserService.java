package com.eAuction.eAuction.User;


import com.eAuction.eAuction.JwtTokenUtil;
import com.eAuction.eAuction.dao.UsersDao;
import com.eAuction.eAuction.dao.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public String CreateUser(RegisterInputDto user){
        UsersDto newUser = new UsersDto();
        UsersDto existingUser = usersDao.findByEmail(user.getEmail());
        if(existingUser != null){
            return "User Already exist";
        }
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAddress(user.getAddress());
        newUser.setCity(user.getCity());
        newUser.setState(user.getState());
        newUser.setPin(user.getPin());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setUserType(user.getUserType());
        newUser.setEmail(user.getEmail());

        newUser.setPassword(generateMD5(user.getPassword()));
        usersDao.saveAndFlush(newUser);

        return "success";
    }

    public LoginResponse LoginUser(LoginInputDto loginData){
        String email = loginData.getEmail();
        String password = generateMD5(loginData.getPassword());

        UsersDto user = usersDao.findByEmailAndPassword(email, password);
        LoginResponse loginResponse = new LoginResponse();
        if(user != null){
            loginResponse.setUser(user);
            loginResponse.setToken(jwtTokenUtil.generateToken(user));
        }
        return loginResponse;
    }

    private String generateMD5(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String passHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return passHash;
    }
}
