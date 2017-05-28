package io.github.wulei123.yibansdkauthjwt.service;

import io.github.wulei123.yibansdkauthjwt.config.JwtMessageConfig;
import io.github.wulei123.yibansdkauthjwt.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.github.wulei123.yibansdkauthjwt.auth.YiBanOauthHandler.decodeYiBanVerifyRequest;
import static io.github.wulei123.yibansdkauthjwt.utils.jwt.JwtHandler.jwtCompact;

/**
 * Created by 武雷 on 2017/5/26.
 */
@Service
public class AuthService{
    @Autowired
    private JwtMessageTemplate jwtMessage;
    @Autowired
    private JwtMessageConfig jwtMessageConfig;
    private YiBanUserInfoTemplate userInfo;

    public Object login(String verifyRequest,String appId,String appKey){
        if(checkAuth().getIsLogin()){
            return new ReturnMessage(1,"You have already login","not login");
        }
        String compactedJws = generateJwt(verifyRequest,appId,appKey);
        return new JwtReturnMessage(compactedJws);
    }

    public ReturnMessage logout(){
        jwtMessage.setIslogin(false);
        return new ReturnMessage(2,"logout successfully","logout successfully");
    }

    public AuthReturnMessage checkAuth() {
        return new AuthReturnMessage(jwtMessage.getIslogin());
    }

    public String generateJwt(String verifyRequest, String appId, String appKey){
        userInfo = (YiBanUserInfoTemplate)decodeYiBanVerifyRequest(verifyRequest,appId,appKey);
        jwtMessage.setUserInfo(userInfo);
        return jwtCompact(jwtMessage,jwtMessageConfig.getSecret());
    }


}