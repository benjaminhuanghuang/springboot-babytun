package ben.study.babytunseckill.service;

import ben.study.babytunseckill.dao.PromotionSecKillDAO;
import ben.study.babytunseckill.entity.PromotionSecKill;
import ben.study.babytunseckill.service.exception.SecKillException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PromotionSecKillService {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;
    @Resource
    private RedisTemplate redisTemplate;

    /*
        seckill id,
        userId
        限购数量
     */
    public void processSecKill(Long psId, String userId, Integer num) throws SecKillException {
        PromotionSecKill promotionSecKill = promotionSecKillDAO.findById(psId);

        if (promotionSecKill == null) {
            throw new SecKillException("Second Kill event does not exist.");
        } else if (promotionSecKill.getStatus() == 0) {
            throw new SecKillException("Second Kill event is not start.");
        } else if (promotionSecKill.getStatus() == 2) {
            throw new SecKillException("Second Kill event is finished.");
        }

        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill:count:" + promotionSecKill.getPsId());
        boolean isUserExisted = redisTemplate.opsForSet().isMember("seckill:users:" + promotionSecKill.getPsId(), userId);
        if (isUserExisted) {
            throw new SecKillException("User existed out");
        }
        if (goodsId != null) {
            System.out.println("Get one. create a order");
            redisTemplate.opsForSet().add("seckill:users:" + promotionSecKill.getPsId(), userId);
        } else {
            throw new SecKillException("Sold out");
        }
    }
}
