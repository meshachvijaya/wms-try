package com.coolvita.wms.repository;

import com.coolvita.wms.entity.GoodsOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoodsOutRepository extends JpaRepository<GoodsOut, UUID> {
}
