
## Create Static page
Modify Controller



# Nginx
```
nginx -s realod

nginx -s quit       # 
nginx -s stop       #
```

niginx config file
```
  server {
      root /tmp/static
      index index.html
  }
```

## Springboot Schedule

Enable Schedule on Application
```
  @EnableScheduling
  public class BabytunApplication {

  }
```
Add schedule task
```
  @Component  // IOC container will load @component
  public class StaticTask {

  }
```

cron expression
```
  0,1,2 * * * * ?s
```

find new updates
```
  select * from t_goods where last_update_time > now()- interval 5 minute
```

