package ben.study.babytunseckill.scheduler;

import ben.study.babytunseckill.dao.PromotionSecKillDAO;
import ben.study.babytunseckill.entity.PromotionSecKill;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SecKillTask {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;

    @Scheduled(cron = "0/5 * * * * ?")
    public void startSecKill() {
        List<PromotionSecKill> list = promotionSecKillDAO.findUnstartSecKill();
        for (PromotionSecKill ps : list) {
            System.out.println(ps.getPsId() + "event is start");
            ps.setStatus(1);
            promotionSecKillDAO.update(ps);
        }
    }
}
