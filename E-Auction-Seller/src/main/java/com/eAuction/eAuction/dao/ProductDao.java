package com.eAuction.eAuction.dao;


import com.eAuction.eAuction.model.ProductDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@EnableMongoRepositories
@Repository
public interface ProductDao extends MongoRepository<ProductDto, Integer> {

    ProductDto findById(String id);

    List<ProductDto> findAll();

    int deleteById(String productId);
}
