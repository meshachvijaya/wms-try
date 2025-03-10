package com.coolvita.wms.controller;

import com.coolvita.wms.entity.ProfitTracking;
import com.coolvita.wms.service.ProfitTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/profit-tracking")
public class ProfitTrackingController {

    @Autowired
    private ProfitTrackingService profitTrackingService;

    @PostMapping
    public ResponseEntity<ProfitTracking> createProfitTracking(@RequestBody ProfitTracking profitTracking) {
        return ResponseEntity.ok(profitTrackingService.createProfitTracking(profitTracking));
    }

    @GetMapping
    public ResponseEntity<List<ProfitTracking>> getAllProfitTracking() {
        return ResponseEntity.ok(profitTrackingService.getAllProfitTracking());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfitTracking> getProfitTrackingById(@PathVariable UUID id) {
        ProfitTracking profitTracking = profitTrackingService.getProfitTrackingById(id);
        return ResponseEntity.ok(profitTracking);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProfitTracking> updateProfitTracking(@PathVariable UUID id, @RequestBody ProfitTracking profitTracking) {
        return ResponseEntity.ok(profitTrackingService.updateProfitTracking(id, profitTracking));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfitTracking(@PathVariable UUID id) {
        profitTrackingService.deleteProfitTracking(id);
        return ResponseEntity.noContent().build();
    }
}
