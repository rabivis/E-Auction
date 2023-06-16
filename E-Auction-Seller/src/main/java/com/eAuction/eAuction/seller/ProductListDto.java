package com.eAuction.eAuction.seller;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.UUID;

@Data
public class ProductListDto {
    private String value;
    private String label;
}
