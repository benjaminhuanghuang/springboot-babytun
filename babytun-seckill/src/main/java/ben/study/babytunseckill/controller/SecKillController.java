package ben.study.babytunseckill.controller;

import ben.study.babytunseckill.service.PromotionSecKillService;
import ben.study.babytunseckill.service.exception.SecKillException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {
    @Resource
    PromotionSecKillService promotionSecKillService;

    @RequestMapping("/seckill")
    @ResponseBody
    public Map processSeckKill(Long psId, String userId){
        Map result = new HashMap();
        try{
            promotionSecKillService.processSecKill(psId, userId, 1);
            result.put("code", "0");
            result.put("message", "success");
        }
        catch (SecKillException e){
            e.printStackTrace();
            result.put("code", "500");
            result.put("message", "success");
        }
        return result;
    }

}
