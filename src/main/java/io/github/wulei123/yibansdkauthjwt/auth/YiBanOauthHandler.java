package io.github.wulei123.yibansdkauthjwt.auth;

import com.google.gson.Gson;
import io.github.wulei123.yibansdkauthjwt.template.ErrorMessage;
import io.github.wulei123.yibansdkauthjwt.template.YiBanUserInfoTemplate;
import io.github.wulei123.yibansdkauthjwt.utils.yiban.Crypto;

/**
 * Created by 武雷 on 2017/5/25.
 */

public class YiBanOauthHandler{
    public static Object decodeYiBanVerifyRequest(String verify_request,String appId,String appKey){
        byte[] sourceInfo = null;
        Crypto crypto = new Crypto(appId,appKey);
        try {
            sourceInfo = crypto.decrypt(verify_request);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("sourceInfo is null");
        }
        YiBanUserInfoTemplate yiBanUserInfo;
        try {
            yiBanUserInfo = new Gson().fromJson(new String(sourceInfo),YiBanUserInfoTemplate.class);
            return yiBanUserInfo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
