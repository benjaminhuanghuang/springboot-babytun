package com.example.demo.dao;

import com.example.demo.entity.Goods;

import java.util.List;

public interface GoodsDAO {
    public Goods findById(Long goodsId);
    public List<Goods> findAllGoods();
    public List<Goods> findLast5M();
}
