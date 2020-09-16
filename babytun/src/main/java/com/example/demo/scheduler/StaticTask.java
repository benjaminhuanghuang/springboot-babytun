package com.example.demo.scheduler;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component  // IOC container will load @component
public class StaticTask {
    @Resource
    private GoodsService goodsService;

    @Resource
    // for static page
    private Configuration freemarkerConfig;


    // Execute on 1 second
    // second min hour day month weekday
    @Scheduled(cron = "* * * * * ?")
    public void doStatic() throws IOException, TemplateException {
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
    }

}
