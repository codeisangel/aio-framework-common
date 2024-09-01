package cn.aio1024.framework.basic.domain.annotations;

import java.lang.annotation.*;

/**
 * 字段注释
 *
 * @author lizhenming
 * @date 2023/7/22
 */
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface KgoField {
    /**  字段描述  */
    String desc() default "";
    /**  是否必须  */
    boolean required() default true;
}
