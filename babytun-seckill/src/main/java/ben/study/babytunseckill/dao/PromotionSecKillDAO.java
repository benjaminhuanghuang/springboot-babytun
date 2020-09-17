package ben.study.babytunseckill.dao;

import ben.study.babytunseckill.entity.PromotionSecKill;

import java.util.List;

public interface PromotionSecKillDAO {
    List<PromotionSecKill> findUnstartSecKill();
    List<PromotionSecKill> findExpiredSecKill();

    void update(PromotionSecKill ps);

    PromotionSecKill findById(Long psId);
}
