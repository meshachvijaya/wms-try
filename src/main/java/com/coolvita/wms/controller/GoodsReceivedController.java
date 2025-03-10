package com.coolvita.wms.controller;

import com.coolvita.wms.entity.GoodsReceived;
import com.coolvita.wms.service.GoodsReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/goods-received")
public class GoodsReceivedController {

    @Autowired
    private GoodsReceivedService goodsReceivedService;

    @PostMapping
    public ResponseEntity<GoodsReceived> createGoodsReceived(@RequestBody GoodsReceived goodsReceived) {
        return ResponseEntity.ok(goodsReceivedService.createGoodsReceived(goodsReceived));
    }

    @GetMapping
    public ResponseEntity<List<GoodsReceived>> getAllGoodsReceived() {
        return ResponseEntity.ok(goodsReceivedService.getAllGoodsReceived());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsReceived> getGoodsReceivedById(@PathVariable UUID id) {
        GoodsReceived goodsReceived = goodsReceivedService.getGoodsReceivedById(id);
        return ResponseEntity.ok(goodsReceived);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<GoodsReceived> updateGoodsReceived(@PathVariable UUID id, @RequestBody GoodsReceived goodsReceived) {
        return ResponseEntity.ok(goodsReceivedService.updateGoodsReceived(id, goodsReceived));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGoodsReceived(@PathVariable UUID id) {
        goodsReceivedService.deleteGoodsReceived(id);
        return ResponseEntity.noContent().build();
    }
}
