package ben.study.seckillsample.dao;

public class SKDao {
    public static Integer count = 10;    // product count for second kill


    public Integer getCount() {
        return SKDao.count;
    }

    public void updateCount(Integer count) {
        SKDao.count = count;
    }
}
