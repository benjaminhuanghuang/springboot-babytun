package ben.study.seckillsample.controller;

import ben.study.seckillsample.service.SKService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SKController {
    @Resource
    private SKService skService = null;


    @GetMapping("/seckill")
    @ResponseBody
    public String doSeckill() {
        skService.processSeckill();
        return "ok";
    }
}
