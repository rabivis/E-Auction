package com.eAuction.eAuction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductDto, Integer> {

    ProductDto findByid(Integer id);

    List<ProductDto> findAll();

}
