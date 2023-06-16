package com.eAuction.eAuction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(value = "BID_DATA")
@CompoundIndex(name = "productId_createdBy", def = "{'productId':1,'createdBy':1}")

public class BidDto {
    @Id
    private String id;

    @NotNull
    private String productId;

    @NotNull
    private int bidAmount;

    @NotNull
    private Date bidDate;

    @NotNull
    private String createdBy;
}
