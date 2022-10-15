package com.eAuction.eAuction.buyer;

import com.eAuction.eAuction.dao.BidDao;
import com.eAuction.eAuction.dao.BidDto;
import com.eAuction.eAuction.dao.ProductDao;
import com.eAuction.eAuction.dao.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BuyerService {

    @Autowired
    BidDao bidDao;

    @Autowired
    ProductDao productDao;

    public String createBid(NewBidInputDto newBidInputDto){
        int productId = newBidInputDto.getProductId();
        int createdBy = newBidInputDto.getCreatedBy();
        int bidAmount = newBidInputDto.getBidAmount();

        BidDto existingBid = bidDao.findByProductIdAndCreatedBy(productId, createdBy);
        if(existingBid != null){
            return "Bid already exist";
        }
        ProductDto productDto = productDao.findByid(productId);
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

        bidDao.saveAndFlush(newBidObject);
        return "Success";
    }

    public String updateBid(NewBidInputDto bidInputDto){

        int productId = bidInputDto.getProductId();
        int createdBy = bidInputDto.getCreatedBy();
        int bidAmount = bidInputDto.getBidAmount();

        BidDto existingBid = bidDao.findByProductIdAndCreatedBy(productId, createdBy);
        if(existingBid == null){
            return "Bid not found";
        }

        ProductDto productDto = productDao.findByid(productId);
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
