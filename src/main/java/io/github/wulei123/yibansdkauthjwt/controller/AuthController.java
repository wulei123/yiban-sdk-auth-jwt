package io.github.wulei123.yibansdkauthjwt.controller;

import io.github.wulei123.yibansdkauthjwt.annotations.YiBanJwtAuth;
import io.github.wulei123.yibansdkauthjwt.annotations.YiBanJwtAdminAuth;
import io.github.wulei123.yibansdkauthjwt.annotations.YiBanJwtLogout;
import io.github.wulei123.yibansdkauthjwt.config.JwtMessageConfig;
import io.github.wulei123.yibansdkauthjwt.config.YiBanOauthConfig;
import io.github.wulei123.yibansdkauthjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.wulei123.yibansdkauthjwt.utils.jwt.JwtHandler.jwtParser;

/**
 * Created by 武雷 on 2017/5/25.
 */

@RestController
@RequestMapping("/auth")
public class AuthController{

    @Autowired
    private YiBanOauthConfig yiBanOauthConfig;

    @Autowired
    private JwtMessageConfig jwtMessageConfig;

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public Object login(String vq) {
        return authService.auth(vq,yiBanOauthConfig.getAppId(),yiBanOauthConfig.getAppKey());
    }


    @RequestMapping("/logout")
    @YiBanJwtLogout
    public Object logout(){return 0;}


    @RequestMapping("/check")
    @YiBanJwtAuth
    public Object checkAuth(){
        return "hello";
    }


    @RequestMapping("/checkAdmin")
    @YiBanJwtAdminAuth
    public void checkCommonAdmin() {

    }
    @RequestMapping("/show")
    public Object show(){
        String verify_request = "12d42600c43a4404ae38fa7499e85b59cfcf99a14cacaaaa38f70aa08d0c36638984d3756a2943823218e9eee9c1ad0e95dcf2e41a7863e0aaf927546d61cfdc3b57883fe47af30907702ad1c514824af8bde7b8cac3ebc470d760f13d27912c87b94870469944aa5786d147551d9ef331ca1759df87b9541d4d111cb6ddcba10a97bf02e96e64cd1cb0828a90ef7faf743c6a9c46f400b64fbc183b0285edcaa1b751defb335115879aa43e01ea9800ee2edb10c4336590e9f529257ab1ba908954660abdcb6be0a1a597696c91979df51c3ee07b20eb55873ea9919a3b3a25767c70321cd8e8d9a9ebe39d0b55016d9ad9f56d15b7d6fda23635a9eb75b7c51ccf9b708f40bd44db0c62b34fa316925e9af9c48f7ad4e0870e1de16f08dbcb";
        String str = authService.generateJwt(verify_request,yiBanOauthConfig.getAppId(),yiBanOauthConfig.getAppKey());
        return jwtParser(str,jwtMessageConfig.getSecret());
    }
}