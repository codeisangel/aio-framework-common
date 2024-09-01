package cn.aio1024.framework.basic.adapter.user.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface AioSecurityVerify {
}
