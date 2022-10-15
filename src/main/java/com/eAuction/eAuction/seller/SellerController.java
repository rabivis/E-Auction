package com.eAuction.eAuction.seller;

import com.eAuction.eAuction.dao.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/v1/seller/")
@RestController
public class SellerController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @PostMapping("/add-product")
    public String addProduct( @Valid @RequestBody AddProductDto product, @RequestHeader("Authorization") String token){
        productService.saveProduct(product);
        return "Success";
    }

    @CrossOrigin
    @GetMapping("/show-bid")
    public ProductWithBidDto showBid(@Valid @RequestParam int productId){
        return productService.fetchProduct(productId);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public String deleteproduct(@Valid @RequestParam int productId){
        return productService.removeProduct(productId);
    }
}
