package com.musinsa.common.utility;

import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;

@Slf4j
public class EncodeUtility {
    private static final int BASE62 = 62;
    private static final String BASE62_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static String encoding(long param) {
        StringBuffer sb = new StringBuffer();

        while(param > 0) {
            sb.append(BASE62_CHAR.charAt((int) (param % BASE62)));
            param /= BASE62;
        }

        return sb.toString();
    }

    public static String urlEncoder(int seq) throws NoSuchAlgorithmException {
        String encodeStr = encoding(seq);
        log.info("base62 encode result => {}", encodeStr);
        return encodeStr;
    }

}