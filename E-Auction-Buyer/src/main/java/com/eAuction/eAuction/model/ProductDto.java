package com.eAuction.eAuction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(value = "PRODUCT")
//@CompoundIndex(name = "email_userType", def = "{'email':1,'userType':1}")
public class ProductDto {

    @Id
    private String id;

    @NotNull
    private String productName;

    @NotNull
    private String shortDescription;

    @NotNull
    private String detailedDescription;

    @NotNull
    private int categoryID;

    @NotNull
    private int startingPrice;

    @NotNull
    private Date bidEndDate;

    @NotNull
    private String createdBy;
}
