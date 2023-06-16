package com.eAuction.eAuction.repository;

import com.eAuction.eAuction.dao.UsersDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface UsersDao extends MongoRepository<UsersDto, Integer> {

    UsersDto findByEmail(String email);

    UsersDto findByEmailAndPassword(String email, String password);
}
