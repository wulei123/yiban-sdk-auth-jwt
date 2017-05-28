package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/27.
 */
public class ReturnMessage {
    private int code;
    private String message;
    private Object detail;

    public ReturnMessage(int code, String message, Object detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }
}
