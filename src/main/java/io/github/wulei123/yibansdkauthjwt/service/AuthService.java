package io.github.wulei123.yibansdkauthjwt.service;

import io.github.wulei123.yibansdkauthjwt.auth.YiBanOauthUtil;
import io.github.wulei123.yibansdkauthjwt.config.JwtMessageConfig;
import io.github.wulei123.yibansdkauthjwt.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.github.wulei123.yibansdkauthjwt.auth.YiBanOauthUtil.decodeYiBanVerifyRequest;
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

    public JwtReturnMessage auth(String verifyRequest,String appId,String appKey){
        String compactedJwt = generateJwt(verifyRequest,appId,appKey);
        return new JwtReturnMessage(compactedJwt);
    }

    public JwtReturnMessage adminAuth(YiBanUserInfoTemplate userInfo,Boolean isAdmin){
        jwtMessage.setUserInfo(userInfo,isAdmin);
        return new JwtReturnMessage(jwtCompact(jwtMessage,jwtMessageConfig.getSecret()));
    }

    /*public ReturnMessage logout(){
        JwtMessageTemplate jwtMessage = new JwtMessageTemplate();
        jwtMessage.setIslogin(false);
        return new ReturnMessage(4,"logout successfully","logout successfully");
    }*/

   /* public AuthReturnMessage checkAuth() {
        return new AuthReturnMessage(jwtMessage.getIslogin());
    }*/

    public String generateJwt(String verifyRequest, String appId, String appKey){
        userInfo = (YiBanUserInfoTemplate)decodeYiBanVerifyRequest(verifyRequest,appId,appKey);
        this.jwtMessage.setUserInfo(userInfo);
        return jwtCompact(jwtMessage,jwtMessageConfig.getSecret());
    }


}