package com.eAuction.eAuction.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "BID_DATA")
public class BidDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "BID_AMOUNT")
    private int bidAmount;

    @Column(name = "BID_DATE")
    private Date bidDate;

    @Column(name = "CREATED_BY")
    private int createdBy;
}
