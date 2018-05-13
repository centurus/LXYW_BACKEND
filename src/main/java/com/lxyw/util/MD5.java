package com.lxyw.util;

import org.springframework.util.DigestUtils;

public class MD5 {

    private static final String SALT="LXYW";

    public static String encryption(String test)throws LXYWException{
        String encodeStr= "";
        try {
            encodeStr = DigestUtils.md5DigestAsHex((test+SALT).getBytes());
        } catch (Exception e) {
            throw new LXYWException(ExceptionCode.MD5_FAIL);
        }
        return new String(encodeStr);
    }
}
