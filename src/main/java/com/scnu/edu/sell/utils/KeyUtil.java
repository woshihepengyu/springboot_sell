package com.scnu.edu.sell.utils;

import java.util.Random;

/**
 * Created by hepengyu in 0826 08:54
 * 生成唯一主键
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
