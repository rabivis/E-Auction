package com.eAuction.eAuction.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "PRODUCT")

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
