package com.coolvita.wms.controller;

import com.coolvita.wms.entity.PurchaseOrder;
import com.coolvita.wms.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(purchaseOrderService.createPurchaseOrder(purchaseOrder));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable UUID id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(purchaseOrder);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable UUID id, @RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(purchaseOrderService.updatePurchaseOrder(id, purchaseOrder));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable UUID id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }

}
