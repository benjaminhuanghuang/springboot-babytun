package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GoodsController {
    @GetMapping("/goods")
    public ModelAndView showGoods(){
        // use the resources/templates/goods.ftl
        ModelAndView mav = new ModelAndView("/goods");
        return mav;
    }

}
