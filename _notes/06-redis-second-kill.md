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
- 在Redis中生成两个对象：produce list， user set




