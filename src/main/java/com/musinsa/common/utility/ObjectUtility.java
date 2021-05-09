package com.musinsa.common.utility;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.cglib.core.Local;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public abstract class ObjectUtility {

    public static boolean isEmpty(Object param) {
        if (param == null) {
            return true;
        }

        if (param instanceof String) {
            return ((String) param).length() == 0 || "".equals(param.toString());
        }

        if (param instanceof Collection) {
            return ((Collection<?>) param).isEmpty();
        }

        if (param instanceof Map) {
            return ((Map<?, ?>) param).isEmpty();
        }

        if (param instanceof Object[]) {
            return ((Object[]) param).length == 0;
        }

        return false;
    }

    public static boolean isNotEmpty(Object param) {
        return !ObjectUtility.isEmpty(param);
    }

    public static boolean urlValidationCheck(String url){
        return new UrlValidator().isValid(url);
    }
}
