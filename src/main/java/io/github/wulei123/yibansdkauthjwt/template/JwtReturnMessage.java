package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/27.
 */
public class JwtReturnMessage {
    private String JsonWebToken;

    public String getJsonWebToken() {
        return JsonWebToken;
    }

    public void setJsonWebToken(String jsonWebToken) {
        JsonWebToken = jsonWebToken;
    }

    public JwtReturnMessage(String jsonWebToken) {
        JsonWebToken = jsonWebToken;
    }
}
