package com.example.demo.service;


import org.springframework.stereotype.Service;
import javax.annotation.Resource;
//
import com.example.demo.dao.GoodsDAO;
import com.example.demo.entity.Goods;

@Service
public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;

    public Goods getGoods(Long goodsId){
        return goodsDAO.findById(goodsId);
    }
}
