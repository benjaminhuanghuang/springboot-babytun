# Maven + SpringBoot2 + MyBatis + MySQL + Redis Project


## Create Springboot projct
- IDE IntelliJ, Install plugin **Spring Assistant** 

- Create project using **Spring Assistant** 
  Web - Spring Web
  Template Engines - Freemarker
  SQL - MySQL + MyBatis

- configration 
Modify resouces/application.yal
```
server:
  port: 80
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/babytun?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456
mybatis:
  mapper-locations: classpath:/mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true          # conver data_table name to dataTable
```

## Bulid the SpringBoot work flow
```
  View -> Controller -> Service -> DAO -> DB
```
- Put css, js, html template under the static foler

- Add controller

- Add service

- Add entity class, dao class and MyBatis xml for the entity