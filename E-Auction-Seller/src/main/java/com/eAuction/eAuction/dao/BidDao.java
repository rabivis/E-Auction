package com.eAuction.eAuction.dao;


import com.eAuction.eAuction.model.BidDto;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface BidDao extends CrudRepository<BidDto, Integer> {

    List<BidDto> findByProductId(String productId);

    int deleteByProductId(String productId);

    BidDto findByProductIdAndCreatedBy(String productId, String createdBy);
}
