package com.coolvita.wms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "goods_received")
public class GoodsReceived extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "po_id")
    private UUID poId;

    @Column(name = "received_date")
    private LocalDateTime receivedDate;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    @Column(name = "unique_code", unique = true)
    private String uniqueCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPoId() {
        return poId;
    }

    public void setPoId(UUID poId) {
        this.poId = poId;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Integer getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(Integer quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
}
