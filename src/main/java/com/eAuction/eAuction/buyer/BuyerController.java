package com.eAuction.eAuction.buyer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1/buyer/")
@RestController
public class BuyerController {

    @CrossOrigin
    @PostMapping("/place-bid")
    public String placeBid(){
        return "Success";
    }

    @CrossOrigin
    @PostMapping("/update-bid")
    public String updateBid(){
        return "Success";
    }
}
