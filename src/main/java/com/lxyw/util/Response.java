package com.lxyw.util;

import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 应答编码  */
    private Integer code = 0;
    /** 应答消息 */
    private String message = "success";
    /** 应答数据 */
    private Object data = null;

    /**
     * 获取应答编码
     *
     * @return 应答编码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置应答编码
     *
     * @param code 应答编码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取应答消息
     *
     * @return 应答消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置应答消息
     *
     * @param message 应答消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取应答数据
     *
     * @return 应答数据
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置应答数据
     *
     * @param data 应答数据
     */
    public void setData(Object data) {
        this.data = data;
    }

    public void initResponseCode(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
