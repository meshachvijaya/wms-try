package com.coolvita.wms.service;

import com.coolvita.wms.entity.GoodsOut;
import com.coolvita.wms.repository.GoodsOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsOutService {

    @Autowired
    private GoodsOutRepository goodsOutRepository;

    public GoodsOut createGoodsOut(GoodsOut goodsOut) {
        goodsOut.setCreatedDate(LocalDateTime.now());
        goodsOut.setUpdatedDate(LocalDateTime.now());
        goodsOut.setCreatedBy("System User");
        goodsOut.setUpdatedBy("System User");

        return goodsOutRepository.save(goodsOut);
    }

    public List<GoodsOut> getAllGoodsOut() {
        return goodsOutRepository.findAll();
    }

    public GoodsOut getGoodsOutById(UUID id) {
        return goodsOutRepository.findById(id).orElse(null);
    }

    public GoodsOut updateGoodsOut(UUID id, GoodsOut goodsOut) {
        GoodsOut existingGoods = getGoodsOutById(id);
        if (existingGoods != null) {
            goodsOut.setId(existingGoods.getId());
            goodsOut.setUpdatedDate(LocalDateTime.now());
            goodsOut.setUpdatedBy("System User");
            return goodsOutRepository.save(goodsOut);
        }
        return null; // or throw an exception
    }

    public void deleteGoodsOut(UUID id) {
        goodsOutRepository.deleteById(id);
    }
}
