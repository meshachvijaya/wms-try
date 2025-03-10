package com.coolvita.wms.repository;

import com.coolvita.wms.entity.GoodsReceived;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoodsReceivedRepository extends JpaRepository<GoodsReceived, UUID> {
}
