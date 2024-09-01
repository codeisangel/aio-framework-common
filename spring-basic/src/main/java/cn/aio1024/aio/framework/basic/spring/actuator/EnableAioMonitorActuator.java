package cn.aio1024.aio.framework.basic.spring.actuator;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lzm
 * @desc 启动监控
 * @date 2024/07/02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({AioActuatorConfig.class})
public @interface EnableAioMonitorActuator {
}
