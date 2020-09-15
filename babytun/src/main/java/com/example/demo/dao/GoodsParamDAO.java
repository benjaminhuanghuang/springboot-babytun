package com.example.demo.dao;

import java.util.List;
//
import com.example.demo.entity.GoodsParam;

public interface GoodsParamDAO {
    public List<GoodsParam> findById(Long goodsId);
}
