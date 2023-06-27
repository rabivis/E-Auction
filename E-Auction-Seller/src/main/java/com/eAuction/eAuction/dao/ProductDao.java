package com.eAuction.eAuction.dao;


import com.eAuction.eAuction.model.ProductDto;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@EnableScan
@Repository
public interface ProductDao extends CrudRepository<ProductDto, Integer> {

    ProductDto findById(String id);

    List<ProductDto> findAll();

    int deleteById(String productId);
}
