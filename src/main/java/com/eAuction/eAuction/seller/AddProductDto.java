package com.eAuction.eAuction.seller;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AddProductDto {

    @NotBlank(message = "Product name is required")
    @Size(min = 5, max = 30, message = "The length of full name must be between 5 to 30 charactor")
    private String productName;

    @NotBlank(message = "Product short description is required")
    private String shortDescription;

    @NotBlank(message = "Product details description is required")
    private String detailedDescription;

    @NotNull(message = "Product category ID is required")
    private int categoryID;

    @NotNull(message = "Product start price is required")
    private int startingPrice;

    @NotNull(message = "Product bid end date is required")
    private Date bidEndDate;

    @NotNull(message = "Product created user is required")
    private int createdBy;
}
