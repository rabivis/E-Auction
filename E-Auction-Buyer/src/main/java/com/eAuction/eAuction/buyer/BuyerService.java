package com.eAuction.eAuction.buyer;

import com.eAuction.eAuction.dao.BidDao;
import com.eAuction.eAuction.model.BidDto;
import com.eAuction.eAuction.dao.ProductDao;
import com.eAuction.eAuction.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class BuyerService {

    @Autowired
    BidDao bidDao;

    @Autowired
    ProductDao productDao;

    public String createBid(NewBidInputDto newBidInputDto){
        String productId = newBidInputDto.getProductId();
        String createdBy = newBidInputDto.getCreatedBy();
        int bidAmount = newBidInputDto.getBidAmount();

        BidDto existingBid = bidDao.findByProductIdAndCreatedBy(productId, createdBy);
        if(existingBid != null){
            return "Bid already exist";
        }
        System.out.println("productId "+ productId);
        ProductDto productDto = productDao.findById(productId);
        if(productDto == null){
            return "Product Id is invalid";
        }
        Date bidEndDate = productDto.getBidEndDate();
        Date currentDate = new Date();
        if(currentDate.after(bidEndDate)){
            return "Bid already expired";
        }

        BidDto newBidObject = new BidDto();
        newBidObject.setProductId(productId);
        newBidObject.setCreatedBy(createdBy);
        newBidObject.setBidAmount(bidAmount);
        newBidObject.setBidDate(newBidInputDto.getBidDate());

        bidDao.save(newBidObject);
        return "Success";
    }

    public String updateBid(NewBidInputDto bidInputDto){

        String productId = bidInputDto.getProductId();
        String createdBy = bidInputDto.getCreatedBy();
        int bidAmount = bidInputDto.getBidAmount();

        BidDto existingBid = bidDao.findByProductIdAndCreatedBy(productId, createdBy);
        if(existingBid == null){
            return "Bid not found";
        }

        ProductDto productDto = productDao.findById(productId);
        if(productDto == null){
            return "Product Id is invalid";
        }
        Date bidEndDate = productDto.getBidEndDate();
        Date currentDate = new Date();
        if(currentDate.after(bidEndDate)){
            return "Bid already expired";
        }
        existingBid.setBidAmount(bidAmount);
        bidDao.save(existingBid);
        return "success";
    }

}
