package com.eAuction.eAuction.dao;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PRODUCT")
@Data
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    @Column(name = "DETAILED_DESCRIPTION")
    private String detailedDescription;

    @Column(name = "CATEGORY_ID")
    private int categoryID;

    @Column(name = "STARTING_PRICE")
    private int startingPrice;

    @Column(name = "BID_END_DATE")
    private Date bidEndDate;

    @Column(name = "CREATED_BY")
    private int createdBy;
}
