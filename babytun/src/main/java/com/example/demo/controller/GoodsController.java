package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
//
import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    /*
        url: /goods?gid=xxx
     */
    @GetMapping("/")
    public ModelAndView showGoods(Long gid) {
        // use the resources/templates/goods.ftl
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        return mav.addObject("goods", goods);
    }
}