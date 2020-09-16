<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title> ${goods.title} </title>
    <link href="./layui/css/layui.css" rel="stylesheet">
    <script src="./layui/layui.all.js"></script>

    <style>
      .bb-info li{
        margin-top: 20px;
      }

      .bb-description li{
        width: 100%;
      }

      .bb-param td:first-child{
        background-color: #eeeeee;
      }
      .layui-this a {
        font-size: 18px;
      }

    </style>
  </head>
  <body>
    <ul>

    </ul>
    <div>
      <#list covers as c >
        <div>
          <img src="${c.gcPicUrl}" style="">
        </div>
      </#list>
    </div>

     <div>
      <#list details as d >
        <div>
          <img src="${d.gdPicUrl}" style="">
        </div>
      </#list>
    </div>


     <div>
        <#list params as p >
          <tr>
            <td>${p.gpParamName}</td>
            <td>${p.gpParamValue}</td>
          </tr>
        </#list>
      </div>
    <div>
      ${goods.title}
      ${goods.subTitle}
      ${goods.currentPrice?string('$0.00')}
      <#if goods.isFreeDelivery==1>Free Delivery</#if>
    </div>

    <script>
      function(){
        // layui contsins jQuery
        var $ = layui.$;
        $.getJSON("/evaluate/${goods.goodsId}", function (json){
          // render evaluate
        })
      }
    </script>
    <div>

    </div>
  </body>

</html>
