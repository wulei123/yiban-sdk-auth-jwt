package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/27.
 */
public class ReturnMessage {
    private int code;
    private String message;
    private Object detail;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public ReturnMessage(int code, String message, Object detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }
}
