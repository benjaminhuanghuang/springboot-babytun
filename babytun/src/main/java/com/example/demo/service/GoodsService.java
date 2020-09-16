package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
//


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
    @Resource
    private EvaluteDAO evaluateDAO;

    @Cacheable(value="goods", key="#goodsId")
    public Goods getGoods(Long goodsId){
        return goodsDAO.findById(goodsId);
    }

    public List<Goods> findAllGoods(){
        return goodsDAO.findAllGoods();
    }

    public List<Goods> findLast5M(){
        return goodsDAO.findLast5M();
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

    public List<Evaluate> findEvaluate(Long goodsId){
        return evaluateDAO.findByGoodsId(goodsId);
    }

}
