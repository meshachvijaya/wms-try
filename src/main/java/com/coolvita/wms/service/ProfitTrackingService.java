package com.coolvita.wms.service;

import com.coolvita.wms.entity.ProfitTracking;
import com.coolvita.wms.repository.ProfitTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProfitTrackingService {

    @Autowired
    private ProfitTrackingRepository profitTrackingRepository;

    public ProfitTracking createProfitTracking(ProfitTracking profitTracking) {
        profitTracking.setCreatedDate(LocalDateTime.now());
        profitTracking.setUpdatedDate(LocalDateTime.now());
        profitTracking.setCreatedBy("System User");
        profitTracking.setUpdatedBy("System User");

        return profitTrackingRepository.save(profitTracking);
    }

    public List<ProfitTracking> getAllProfitTracking() {
        return profitTrackingRepository.findAll();
    }

    public ProfitTracking getProfitTrackingById(UUID id) {
        return profitTrackingRepository.findById(id).orElse(null);
    }

    public ProfitTracking updateProfitTracking(UUID id, ProfitTracking profitTracking) {
        ProfitTracking existingProfit = getProfitTrackingById(id);
        if (existingProfit != null) {
            profitTracking.setId(existingProfit.getId());
            profitTracking.setUpdatedDate(LocalDateTime.now());
            profitTracking.setUpdatedBy("System User");
            return profitTrackingRepository.save(profitTracking);
        }
        return null; // or throw an exception
    }

    public void deleteProfitTracking(UUID id) {
        profitTrackingRepository.deleteById(id);
    }
}
