package com.example.demo.dao;


import java.util.List;
//
import com.example.demo.entity.GoodsCover;

public interface GoodsCoverDAO {
    public List<GoodsCover> findByGoodsId(Long goodsId);
}
