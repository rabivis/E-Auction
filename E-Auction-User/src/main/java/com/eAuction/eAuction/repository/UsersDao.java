package com.eAuction.eAuction.repository;

import com.eAuction.eAuction.dao.UsersDto;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface UsersDao extends CrudRepository<UsersDto, Integer> {

    UsersDto findByEmail(String email);

    UsersDto findByEmailAndPassword(String email, String password);
}
