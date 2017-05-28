package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/27.
 */
public class AuthReturnMessage {
    private boolean isLogin;

    public AuthReturnMessage(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
