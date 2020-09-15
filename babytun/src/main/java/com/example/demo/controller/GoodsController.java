package com.example.demo.controller;


import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import freemarker.template.Configuration;
//
import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Resource
    // for static page
    private Configuration freemarkerConfig;

    /*
        url: /goods?gid=xxx
     */
    @GetMapping("/goods")
    public ModelAndView showGoods(Long gid) {
        // use the resources/templates/goods.ftl
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.findCovers(gid));
        mav.addObject("details", goodsService.findDetails(gid));
        mav.addObject("params", goodsService.findParams(gid));
        return mav;
    }

    @GetMapping("/static/{gid}")
    @ResponseBody
    public String doStatic(@PathVariable("gid") Long gid) throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        Map param = new HashMap();
        param.put("goods", goodsService.getGoods(gid));
        param.put("covers", goodsService.findCovers(gid));
        param.put("details", goodsService.findDetails(gid));
        param.put("params", goodsService.findParams(gid));

        File targetFile = new File("~/temp/goods/" + gid + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param, out);
        out.close();

        return "OK";
    }

    @GetMapping("/static_all")
    @ResponseBody
    public String doStatic() throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        List<Goods> allGoods = goodsService.findAllGoods();

        for (Goods g : allGoods) {
            Map param = new HashMap();
            param.put("goods", goodsService.getGoods(g.getGoodsId()));
            param.put("covers", goodsService.findCovers(g.getGoodsId()));
            param.put("details", goodsService.findDetails(g.getGoodsId()));
            param.put("params", goodsService.findParams(g.getGoodsId()));

            File targetFile = new File("~/temp/goods/" + g.getGoodsId() + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param, out);
            out.close();
        }
        return "OK";
    }
}