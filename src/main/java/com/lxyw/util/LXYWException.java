package com.lxyw.util;

public class LXYWException extends Exception {

    /** 异常编码 */
    private ExceptionCode code = ExceptionCode.UNKNOWN;

    public LXYWException(){
        super();
    }

    /**
     * 构造函数异常
     * @param code
     */
    public LXYWException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
