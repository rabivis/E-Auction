package com.eAuction.eAuction.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidDao extends JpaRepository<BidDto, Integer> {

    List<BidDto> findByProductId(int productId);

    int deleteByProductId(int productId);

    BidDto findByProductIdAndCreatedBy(int productId, int createdBy);
}
