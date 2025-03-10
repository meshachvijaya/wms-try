package com.coolvita.wms.repository;

import com.coolvita.wms.entity.ProfitTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfitTrackingRepository extends JpaRepository<ProfitTracking, UUID> {
}
