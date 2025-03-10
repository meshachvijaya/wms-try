package com.coolvita.wms.service;

import com.coolvita.wms.entity.PurchaseOrder;
import com.coolvita.wms.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseOrderService {

    private String sysName = "System User";

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        // Set Created and Updated fields
        purchaseOrder.setCreatedDate(LocalDateTime.now());
        purchaseOrder.setUpdatedDate(LocalDateTime.now());
        purchaseOrder.setCreatedBy(sysName);
        purchaseOrder.setUpdatedBy(sysName);

        return purchaseOrderRepository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(UUID id) {
        return purchaseOrderRepository.findById(id).orElse(null);
    }

    public PurchaseOrder updatePurchaseOrder(UUID id, PurchaseOrder purchaseOrder) {
        purchaseOrder.setPoId(id);
        purchaseOrder.setUpdatedDate(LocalDateTime.now());
        purchaseOrder.setUpdatedBy(sysName);
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(UUID id) {
        purchaseOrderRepository.deleteById(id);
    }
}
