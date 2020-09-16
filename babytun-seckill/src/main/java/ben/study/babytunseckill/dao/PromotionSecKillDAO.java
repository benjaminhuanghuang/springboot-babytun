package ben.study.babytunseckill.dao;

import ben.study.babytunseckill.entity.PromotionSecKill;

import java.util.List;

public interface PromotionSecKillDAO {
    List<PromotionSecKill> findUnstartSecKill();

    void update(PromotionSecKill ps);

    PromotionSecKill findById(Long psId);
}
