package com.eAuction.eAuction.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public ProductWithBidDto showBid(@Valid @RequestParam String productId){
        return productService.fetchProduct(productId);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public String deleteproduct(@Valid @RequestParam String productId){
        return productService.removeProduct(productId);
    }

    @CrossOrigin
    @GetMapping("/product-list")
    public ResponseEntity<?> showProductList() {
        List<ProductListDto> response = productService.fetchAllProduct();
        return ResponseEntity.ok().body(response);
    }
}
