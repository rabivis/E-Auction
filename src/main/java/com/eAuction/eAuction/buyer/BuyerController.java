package com.eAuction.eAuction.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/api/v1/buyer/")
@RestController
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @CrossOrigin
    @PostMapping("/place-bid")
    public ResponseEntity<?> placeBid(@Valid @RequestBody NewBidInputDto newBidInputDto){
        String response = buyerService.createBid(newBidInputDto);
        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @PostMapping("/update-bid")
    public ResponseEntity<?> updateBid(@Valid @RequestBody NewBidInputDto newBidInputDto){
        String response = buyerService.updateBid(newBidInputDto);
        return ResponseEntity.ok().body(response);
    }
}
