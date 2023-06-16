package com.eAuction.eAuction.dao;


import com.eAuction.eAuction.model.BidDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
@Repository
public interface BidDao extends MongoRepository<BidDto, Integer> {

    List<BidDto> findByProductId(String productId);

    int deleteByProductId(String productId);

    BidDto findByProductIdAndCreatedBy(String productId, String createdBy);
}
