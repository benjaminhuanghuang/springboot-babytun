package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
//
import com.example.demo.dao.GoodsDAO;
import com.example.demo.dao.GoodsCoverDAO;
import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsCover;



@Service
public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;
    @Resource
    private GoodsCoverDAO goodsCoverDAO;

    public Goods getGoods(Long goodsId){
        return goodsDAO.findById(goodsId);
    }


    public List<GoodsCover> findCovers(Long goodsId){
        return goodsCoverDAO.findByGoodsId(goodsId);
    }
}
