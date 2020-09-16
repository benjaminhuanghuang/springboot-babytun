package com.example.demo.dao;

import com.example.demo.entity.Evaluate;
import com.example.demo.entity.Goods;

import java.util.List;

public interface EvaluteDAO {
    public List<Evaluate> findByGoodsId(Long goodsId);
}
