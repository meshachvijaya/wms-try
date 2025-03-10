package com.coolvita.wms.controller;

import com.coolvita.wms.entity.GoodsOut;
import com.coolvita.wms.service.GoodsOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/goods-out")
public class GoodsOutController {

    @Autowired
    private GoodsOutService goodsOutService;

    @PostMapping
    public ResponseEntity<GoodsOut> createGoodsOut(@RequestBody GoodsOut goodsOut) {
        return ResponseEntity.ok(goodsOutService.createGoodsOut(goodsOut));
    }

    @GetMapping
    public ResponseEntity<List<GoodsOut>> getAllGoodsOut() {
        return ResponseEntity.ok(goodsOutService.getAllGoodsOut());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsOut> getGoodsOutById(@PathVariable UUID id) {
        GoodsOut goodsOut = goodsOutService.getGoodsOutById(id);
        return ResponseEntity.ok(goodsOut);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<GoodsOut> updateGoodsOut(@PathVariable UUID id, @RequestBody GoodsOut goodsOut) {
        return ResponseEntity.ok(goodsOutService.updateGoodsOut(id, goodsOut));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGoodsOut(@PathVariable UUID id) {
        goodsOutService.deleteGoodsOut(id);
        return ResponseEntity.noContent().build();
    }
}
