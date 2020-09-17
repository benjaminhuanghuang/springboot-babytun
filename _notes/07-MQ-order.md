##

## Create two pages
Add order.ftl, waiting.ftl

## order data table

t_order
```
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) NOT NULL,
  `order_status` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `recv_name` varchar(255) NOT NULL,
  `recv_address` varchar(255) NOT NULL,
  `recv_mobile` varchar(255) NOT NULL,
  `postage` float DEFAULT NULL,
  `amout` float DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci
```

entity


MyBatis mapping xml



## Add MQ dependencies 
```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
  </dependency>
```
