package com.eAuction.eAuction.dao;


import com.eAuction.eAuction.model.ProductDto;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface ProductDao extends CrudRepository<ProductDto, Integer> {

    ProductDto findById(String id);
}
