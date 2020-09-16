# 动静数据分类
更有效的使用static page

Using Ajax load dynamic data

## Take the Evaluate as the sample
Create controller

## Map requst to SpringBoot server
```
  location /evaluate {
    proxy_pass  http://localhost:8080/evalute/;
    prox_set_header Host $host
    prox_set_header X-Forwarded-for $proxy_add_x_forwared_for
  }
```