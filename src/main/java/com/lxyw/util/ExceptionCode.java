package com.lxyw.util;

public enum ExceptionCode {

    UNKNOWN(0,"失败,原因不明"),
    MD5_FAIL(1,"加密失败"),
    ERROR_PASSWORD(3,"用户名密码不匹配");

    private int code;

    private String message;

    private ExceptionCode(int code,String message){
        this.code = code;
        this.message = message;
    }
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
}
