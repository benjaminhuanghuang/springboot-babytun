
## Cache
- 读取是主要操作
- 稳定数据：商品信息，用户信息，网站信息

## Add cache and redis to springboot project
Dependencies
```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
  </dependency>
```

application.yml for redis
```
  redis:
    database: 3
    host: 127.0.0.1
    port: 6379
    jedis:
      pool:
        max-active: 100
        max-idle: 100
        min-idle: 10
        max-wait: 100ms
```

Enable cache on Application
```
  @EnableCaching
  public class BabytunApplication {

  }
```

Add cache on service
```
  @Cacheable(value="goods", key="#goodsId")
  public Goods getGoods(Long goodsId){
      return goodsDAO.findById(goodsId);
  }
```

The entites need implement Serializable interface
```
  public class GoodsDetail implements Serializable {

    ...
  }
```