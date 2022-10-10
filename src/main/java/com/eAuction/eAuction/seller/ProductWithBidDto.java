package com.eAuction.eAuction.seller;

import com.eAuction.eAuction.dao.BidDto;
import com.eAuction.eAuction.dao.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductWithBidDto {
    private ProductDto product;
    private List<BidDto> bidData;
}
