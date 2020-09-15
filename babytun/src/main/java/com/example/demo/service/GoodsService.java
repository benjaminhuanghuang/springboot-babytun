package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.GoodsDetailDAO;
import com.example.demo.dao.GoodsParamDAO;
import com.example.demo.entity.GoodsDetail;
import com.example.demo.entity.GoodsParam;
import org.springframework.cache.annotation.Cacheable;
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
    @Resource
    private GoodsDetailDAO goodsDetailDAO;
    @Resource
    private GoodsParamDAO goodsParamDAO;

    @Cacheable(value="goods", key="#goodsId")
    public Goods getGoods(Long goodsId){
        return goodsDAO.findById(goodsId);
    }

    public List<Goods> findAllGoods(){
        return goodsDAO.findAllGoods();
    }

    @Cacheable(value="covers", key="#goodsId")
    public List<GoodsCover> findCovers(Long goodsId){
        return goodsCoverDAO.findByGoodsId(goodsId);
    }

    @Cacheable(value="details", key="#goodsId")
    public List<GoodsDetail> findDetails(Long goodsId){
        return goodsDetailDAO.findByGoodsId(goodsId);
    }

    @Cacheable(value="params", key="#goodsId")
    public List<GoodsParam> findParams(Long goodsId){
        return goodsParamDAO.findByGoodsId(goodsId);
    }
}
