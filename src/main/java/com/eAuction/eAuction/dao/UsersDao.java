package com.eAuction.eAuction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<UsersDto, Integer> {

    UsersDto findByEmail(String email);

    UsersDto findByEmailAndPassword(String email, String password);
}
