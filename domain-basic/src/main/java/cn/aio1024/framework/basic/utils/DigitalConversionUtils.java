package cn.aio1024.framework.basic.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lizhenming
 * @desc: 进制转化工具类
 * @date 2023/8/11 16:12
 */
public class DigitalConversionUtils {

    private final static AtomicLong count62 = new AtomicLong(1);
    private final static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final static int scale = 62;


    /**
     * 获取64位时间戳
     *
     * @return java.lang.String
     **/
    public static String timestampTo62(){
        return encode62(System.currentTimeMillis()+count62.getAndAdd(1),8);
    }

    /**
     * 十进制转化为62进制
     *
     * @param metaNum: 数据
     * @param length: 长度
     * @return java.lang.String
     **/
    public static String encode62(long metaNum, int length) {
        StringBuilder sb = new StringBuilder();
        long num;
        for(num = metaNum; num > (long)(scale - 1); num /= (long)scale) {
            int remainder = Long.valueOf(num % (long)scale).intValue();
            sb.append(chars.charAt(remainder));
        }

        sb.append(chars.charAt(Long.valueOf(num).intValue()));
        String value = sb.reverse().toString();
        return StringUtils.leftPad(value, length, '0');
    }
    /**
     * 字符串转化为10进制
     *
     * @param str:62进制字符串
     * @return long
     **/
    public static long decode62(String str) {
        str = str.replace("^0*", "");
        long num = 0L;

        for(int i = 0; i < str.length(); ++i) {
            int index = chars.indexOf(str.charAt(i));
            num += (long)((double)index * Math.pow((double)scale, (double)(str.length() - i - 1)));
        }

        return num;
    }
}
