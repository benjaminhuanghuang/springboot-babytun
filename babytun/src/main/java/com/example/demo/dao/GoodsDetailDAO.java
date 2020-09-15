package com.example.demo.dao;

import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsDetail;

import java.util.List;

public interface GoodsDetailDAO {
    public List<GoodsDetail> findById(Long goodsId);
}
