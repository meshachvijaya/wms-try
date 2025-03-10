package com.coolvita.wms.service;

import com.coolvita.wms.entity.GoodsReceived;
import com.coolvita.wms.repository.GoodsReceivedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsReceivedService {

    @Autowired
    private GoodsReceivedRepository goodsReceivedRepository;

    public GoodsReceived createGoodsReceived(GoodsReceived goodsReceived) {
        goodsReceived.setCreatedDate(LocalDateTime.now());
        goodsReceived.setUpdatedDate(LocalDateTime.now());
        goodsReceived.setCreatedBy("System User");
        goodsReceived.setUpdatedBy("System User");

        return goodsReceivedRepository.save(goodsReceived);
    }

    public List<GoodsReceived> getAllGoodsReceived() {
        return goodsReceivedRepository.findAll();
    }

    public GoodsReceived getGoodsReceivedById(UUID id) {
        return goodsReceivedRepository.findById(id).orElse(null);
    }

    public GoodsReceived updateGoodsReceived(UUID id, GoodsReceived goodsReceived) {
        GoodsReceived existingGoods = getGoodsReceivedById(id);
        if (existingGoods != null) {
            goodsReceived.setId(existingGoods.getId());
            goodsReceived.setUpdatedDate(LocalDateTime.now());
            goodsReceived.setUpdatedBy("System User");
            return goodsReceivedRepository.save(goodsReceived);
        }
        return null; // or throw an exception
    }

    public void deleteGoodsReceived(UUID id) {
        goodsReceivedRepository.deleteById(id);
    }
}
