package com.eAuction.eAuction.buyer;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class NewBidInputDto {

    @NotNull(message = "Porduct ID is required")
    private int productId;

    @NotNull(message = "Created by is required")
    private int createdBy;

    @NotNull(message = "Bid amount is required")
    private int bidAmount;

    @NotNull(message = "Bid date is required")
    private Date bidDate;
}
