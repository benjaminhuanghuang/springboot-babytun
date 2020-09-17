package ben.study.babytunseckill.scheduler;

import ben.study.babytunseckill.dao.PromotionSecKillDAO;
import ben.study.babytunseckill.entity.PromotionSecKill;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SecKillTask {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;

    @Resource
    private RedisTemplate redisTemplate;   // redis client provided by springboot


    @Scheduled(cron = "0/5 * * * * ?")
    public void startSecKill() {
        List<PromotionSecKill> list = promotionSecKillDAO.findUnstartSecKill();
        for (PromotionSecKill ps : list) {
            System.out.println(ps.getPsId() + "event is start");
            // clean
            redisTemplate.delete("seckill:count:" + ps.getPsId());
            // add items into product list in Redis
            for (int i = 0; i < ps.getPsCount(); i++) {
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId(), ps.getGoodsId());
            }
            ps.setStatus(1);
            promotionSecKillDAO.update(ps);
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void endSecKill() {
        List<PromotionSecKill> list = promotionSecKillDAO.findExpiredSecKill();
        for (PromotionSecKill ps : list) {
            ps.setStatus(2);
            promotionSecKillDAO.update(ps);
            redisTemplate.delete("seckill:count:" + ps.getPsId());
        }
    }
}
