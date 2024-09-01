package cn.aio1024.framework.basic.domain.annotations;

import java.lang.annotation.*;

/**
 * 参数注解
 *
 * @author lizhenming
 * @date 2023/7/22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface KgoType {
    String desc();
}