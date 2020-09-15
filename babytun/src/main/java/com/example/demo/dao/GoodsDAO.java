package com.example.demo.dao;

import com.example.demo.entity.Goods;

public interface GoodsDAO {
    public Goods findById(Long goodsId);
}
