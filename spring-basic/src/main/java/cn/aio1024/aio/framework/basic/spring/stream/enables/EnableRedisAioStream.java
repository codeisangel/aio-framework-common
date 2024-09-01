package cn.aio1024.aio.framework.basic.spring.stream.enables;

import cn.aio1024.aio.framework.basic.spring.stream.config.AioRedisStreamMessageConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * 启动redisAIoStream
 *
 * @author lizhenming
 * @date 2023/9/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AioRedisStreamMessageConfig.class)
public @interface EnableRedisAioStream {
}
