package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/26.
 */
public class AdminReturnMessage{
    private boolean isAdmin;

    public AdminReturnMessage(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}