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
JSONP 处理逻辑是在页面动态创建的一个script标签，而script标签返回的是JS代码