package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/27.
 */
public class ErrorMessage {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorMessage(String error) {
        this.error = error;
    }
}
