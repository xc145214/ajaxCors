# ajax 跨域完全解决

---

## ajax 跨域问题产生的原因：
+ 浏览器安全限制
+ 跨域
+ 请求类型是 XHR（XmlHttpRequest）

## 解决思路
### 浏览器安全限制
客户点禁止浏览器安全检查
在浏览器的安装目录启动终端，输入禁止浏览器做跨域检查的校验参数，新启一个浏览器。
```
chrome --disable-web-security --user-data-dir=g:\temp3
```

### 使用JSONP解决跨域
前后端都需要修改代码
前端请求：
```
            $.ajax({
					url: base +"/get1",
					dataType: "jsonp",
					jsonp: "callback",
					cache:true,
					type:"get",
					success: function(json){
						result = json;
					}
				});
```
服务端需要同步处理代码：
```
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice() {
        super("callback");
    }
}
```
jsonp是一种非正式传输协议，是前后台约定的协议，而不是官方协议。

JSONP 处理逻辑是在页面动态创建的一个script标签，而script标签返回的是JS代码。

jsonp的实现原理是：前后台约定带有“callback”这个参数的请求就是jsonp请求，前台发出去的请求加了“callback”参数，当后台发现请求中带“callback”时，后台就知道这是一个jsonp请求，就会把返回
的数据由json变成JS代码返回，JS代码内容就是一个函数的调用，函数名是“callback”参数的值，而原来需要返回的json对象数据在这里作为参数传递返回。

###JSONP的弊端
+ 服务器需要修改代码支持
+ 只支持GET请求
+ 发送的不是XHR请求


### 被调用方支持跨域
+ 服务端实现
+ nginx配置
+ Apache配置

### 服务端实现-Filter解决方案


### 常见请求
+ 简单请求
方法为：GET HEAD POST
请求header里面：
    无自定义请求头
    content-type为：text/plain multipart/form-data application/x-www-form-urlencoded

+ 非简单请求
方法为PUT DELETE的ajax 请求
发送json格式的 ajax 请求
发送自定义头的 ajax 请求

非简单请求会发送方法为 OPTIONS的预检命令，通过缓存减少预检命令。