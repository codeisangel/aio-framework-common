package cn.aio1024.framework.basic.domain.utils.reflect;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/7/22 15:31
 */
public class TypeUtils {
    public static Boolean isBasicType(Class<?> type){
        if (type.equals(String.class)){
            return true;
        }else if (type.equals(Integer.class) || type.equals(int.class)){
            return true;
        }else if (type.equals(Float.class) || type.equals(float.class)){
            return true;
        } else if (type.equals(Boolean.class) || type.equals(boolean.class)){
            return true;
        }else if (type.equals(Double.class) || type.equals(double.class)){
            return true;
        }else if (type.equals(BigDecimal.class)){
            return true;
        }else if (type.equals(Long.class) || type.equals(long.class)){
            return true;
        }
        return false;
    }

    public static String getTypeStr(Object body){
        Class<?> type = body.getClass();
        if (type.equals(String.class)){
            return body.toString();
        }else if (type.equals(Integer.class) || type.equals(int.class)){
            return String.valueOf(body);
        }else if (type.equals(Float.class) || type.equals(float.class)){
            return String.valueOf(body);
        } else if (type.equals(Boolean.class) || type.equals(boolean.class)){
            return String.valueOf(body);
        }else if (type.equals(Double.class) || type.equals(double.class)){
            return String.valueOf(body);
        }else if (type.equals(BigDecimal.class)){
            BigDecimal decimal = (BigDecimal)body;
            return decimal.toString();
        }else if (type.equals(Long.class) || type.equals(long.class)){
            return String.valueOf(body);
        }
        return JSON.toJSONString(body);
    }
}
