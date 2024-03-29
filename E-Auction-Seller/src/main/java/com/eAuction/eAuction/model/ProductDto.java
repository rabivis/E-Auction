package com.eAuction.eAuction.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "PRODUCT")
//@CompoundIndex(name = "email_userType", def = "{'email':1,'userType':1}")
public class ProductDto {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @NotNull
    @DynamoDBAttribute
    private String productName;

    @NotNull
    @DynamoDBAttribute
    private String shortDescription;

    @NotNull
    @DynamoDBAttribute
    private String detailedDescription;

    @NotNull
    @DynamoDBAttribute
    private int categoryID;

    @NotNull
    @DynamoDBAttribute
    private int startingPrice;

    @NotNull
    @DynamoDBAttribute
    private Date bidEndDate;

    @NotNull
    @DynamoDBAttribute
    private String createdBy;
}
