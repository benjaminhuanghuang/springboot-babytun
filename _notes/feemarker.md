
## data and format
```
  ${goods.title}
  ${goods.subTitle}
  ${goods.currentPrice?string('$0.00')}
    
```
## If
```
  <#if goods.isFreeDelivery==1>Free Delivery</#if>
```

## For loop
```
  <#list covers as c >
    <div>
      <img src="${c.gcPicUrl}" style="">
    </div>
  </#list>

```