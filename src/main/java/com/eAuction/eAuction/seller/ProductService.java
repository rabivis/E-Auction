package com.eAuction.eAuction.seller;

import com.eAuction.eAuction.dao.BidDao;
import com.eAuction.eAuction.dao.BidDto;
import com.eAuction.eAuction.dao.ProductDao;
import com.eAuction.eAuction.dao.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private BidDao bidDao;

    public String saveProduct(AddProductDto addProductData){
        ProductDto productDto = new ProductDto();
        productDto.setProductName(addProductData.getProductName());
        productDto.setShortDescription(addProductData.getShortDescription());
        productDto.setDetailedDescription(addProductData.getDetailedDescription());
        productDto.setCategoryID(addProductData.getCategoryID());
        productDto.setCreatedBy(addProductData.getCreatedBy());
        productDto.setBidEndDate(addProductData.getBidEndDate());
        productDto.setStartingPrice(addProductData.getStartingPrice());
        productDao.saveAndFlush(productDto);
        AddProductDto addProductDto = new AddProductDto();
        return "Saved";
    }

    public ProductWithBidDto fetchProduct(int productId){
        ProductWithBidDto productWithBidDto = new ProductWithBidDto();
        productWithBidDto.setProduct(productDao.findByid(productId));
        productWithBidDto.setBidData( bidDao.findByProductId(productId));
        return productWithBidDto;
    }

    public String removeProduct(int productId){
        List<BidDto> bidDtos = bidDao.findByProductId(productId);
        if(bidDtos.size() > 0){
            ProductDto productDto = productDao.findByid(productId);
            Date bidEndDate = productDto.getBidEndDate();
            Date currentDate = new Date();
            if(currentDate.before(bidEndDate)){
                return "Unable to remove Product Data";
            }
        }
         productDao.deleteById(productId);
         bidDao.deleteByProductId(productId);
         return "Success";
    }

    public List<ProductListDto> fetchAllProduct(){
        List<ProductDto> productList = productDao.findAll();
        List<ProductListDto> productListDto = new ArrayList<>();
        if(productList.size() > 0){
            for(int i=0; productList.size() > i; i++){

                ProductListDto productListObj = new ProductListDto();
                productListObj.setLabel(productList.get(i).getProductName());
                productListObj.setValue(productList.get(i).getId());
                productListDto.add(productListObj);
            }
        }
        return productListDto;
    }
}
