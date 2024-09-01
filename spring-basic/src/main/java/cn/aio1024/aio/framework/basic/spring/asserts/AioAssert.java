package cn.aio1024.aio.framework.basic.spring.asserts;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public class AioAssert extends Assert {
    public static void isBlank(String str,String message){
        if (StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
    }
    /**
     * 判断是不是手机号
     * @param phone
     * @param message
     */
    public static void isPhone(String phone,String message){
        if (!NumberUtil.isNumber(phone)){
            throw new IllegalArgumentException(message);
        }
        if (StringUtils.length(phone) > 11){
            throw new IllegalArgumentException(message);
        }
        if (StringUtils.length(phone) < 11){
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否是空对象
     * @param object
     * @param message
     */
    public static void isEmptyObj(Object object,String message){
        if (ObjectUtil.isEmpty(object)){
            throw new IllegalArgumentException(message);
        }
    }
    public static void isEmail(String email,String message){

    }

}
