# yiban-sdk-auth-jwt

## 关于

这是一个基于JsonWebToken的易班oauth sdk，目的是简化易班整体开发，并提供一个独立的，灵活的模块化的OauthSDK

## 使用

引入jar包，点击[这里](https://github.com/wulei123/yiban-sdk-auth-jwt/releases/tag/0.01-beta)下载

将此Jar包放入classpath


* 配置登陆点
```java
//普通用户
@Autowired
private AuthService authService

@RequestMapping("/auth")
public Object toAuth(String vq){
    Object result = authService.auth(vq,yourAppId,yourAppSecret)
    return result;
}
//你并不需要检查登陆 因为所有被@YiBanJwtAuth 和 @YiBanConmmonAdminAuth修饰的都会被拦截器拦截 
//并返回错误信息

@Autowired
private AuthService authService;
@RequestMapping("/admin/auth")
public Object toAdminAuth(String vq){
    YiBanUserInfoTemplate userInfo = (YiBanUserInfoTempalte)YiBanOauthUtil.decodeYiBanVerifyRequest(vq,"acaec190548725cf","6b7d82af041da97d586ad8b8d8204225");
    /*your code to judge...*/
    return authService.adminAuth(userInfo,isAdmin)
}
```


* 配置拦截器(Java)

```java
@Configuration
@ComponentScan("io.github.wulei123.yibansdkauthjwt")
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private JwtAuthInterceptor jwtAuthInterceptor;
    @Autowired
    private JwtCommonAdminInterceptor jwtCommonAdminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtAuthInterceptor);
        registry.addInterceptor(jwtCommonAdminInterceptor);
    }
}
```



* 如果你想拦截普通用户登陆 使用 @YiBanJwtAuth 注解装饰该方法即可

```java
@YiBanJwtAuth
public Object doSomeThing(){ ... }
```

* 如果你想拦截管理员登陆 使用 @YiBanJwtCommonAdminAuth 注解装饰该方法即可

```java
@YiBanJwtCommonAdminAuth
public Object doSomeThing(){ ... }
```

* yml配置
```yaml
yibanoauth:
    app:
        appId: yourappid
        appKey: yourappsecret
     jwt:
        secret: secret
        expiresSecond: 147800
```

* 前端请求

认证时将 verify_request 转发至你设定的auth地址

认证成功后将JWT返回给前端

每次向后端发送请求时要在Header中包含键为"YiBan-JWT"
值为上一步返回的的JWT即可

* 错误码对照表

错误码 | 错误类型
:---: | :----:
0 | 没有登陆
1 | 登陆成功或已登陆却重复认证
2 | token过期
3 | 不是管理员
4 | 未知错误
6 | Header中不包含YiBan-JWT
