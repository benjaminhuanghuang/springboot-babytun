## Key points
- 瞬间超高访问量
- 数量有限，防止超卖, 不允许重复买
  Reason: 多个用户同时读到了count，获得了购买权
- 有时间限制，start， end

## JMeter 模拟超卖

## Why Redis
- Redis use single thread -> 超卖，重复买
- Redis 10W QPS           -> 高并发
- distributed system      -> 高并发

## How
在Redis中生成两个对象：produce list， user set

produce list 的key是 seckill:count:seckill-id, value是produce list

user set 的key是 seckill:users:seckill-id


## Second Kill data table
t_promotion_seckill
```
  ps_id            bgint    PK
  goods_id         int
  ps_count         int               # count
  start_time       datetime
  end_time         datetime
  status           int               #
  current_price    float
```
```
CREATE TABLE `t_promotion_seckill` (
  `ps_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `ps_count` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int(11) DEFAULT NULL,
  `current_price` float DEFAULT NULL,
  PRIMARY KEY (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci
```


