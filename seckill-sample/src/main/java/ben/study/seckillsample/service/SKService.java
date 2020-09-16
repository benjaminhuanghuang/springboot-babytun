package ben.study.seckillsample.service;

import ben.study.seckillsample.dao.SKDao;
import org.springframework.stereotype.Service;

@Service
public class SKService {
    private SKDao skDao = new SKDao();

    public void processSeckill() {
        Integer count = skDao.getCount();   // read db
        if (count > 0) {
            System.out.println("You get 1 ");
            count--;
            skDao.updateCount(count);
        } else {
            System.out.println("Sold out");
        }
    }
}
