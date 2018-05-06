package com.lxyw.util;

public enum ResponseCode {
    SUCCESS(0,"成功"),
    FAIL(1,"失败,原因不明"),
    NOT_UNIQUE_USER(2,"注册用户不唯一"),
    ERROR_PASSWORD(3,"用户名密码不匹配");

    private int code;

    private String message;

    private ResponseCode(int code,String message){
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
