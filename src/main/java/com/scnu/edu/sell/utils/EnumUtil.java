package com.scnu.edu.sell.utils;


import com.scnu.edu.sell.enums.CodeEnum;

/**
 * Created by hepengyu in 0826
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
