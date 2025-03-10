package com.coolvita.wms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "goods_out")
public class GoodsOut extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity_out")
    private Integer quantityOut;

    @Column(name = "out_date")
    private LocalDateTime outDate;

    @Column(name = "destination")
    private String destination;

    @Column(name = "unique_code", unique = true)
    private String uniqueCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantityOut() {
        return quantityOut;
    }

    public void setQuantityOut(Integer quantityOut) {
        this.quantityOut = quantityOut;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDateTime outDate) {
        this.outDate = outDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
