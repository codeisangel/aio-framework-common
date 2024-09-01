package cn.aio1024.aio.framework.basic.spring.stream.config;

import cn.aio1024.aio.framework.basic.spring.stream.bo.AioRedisStreamConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:13
 */
@Data
@ConfigurationProperties(prefix="aio.stream.upload")
public class AioSteamMessageProperties {
    private String applicationId;
    private String serviceAddr;
    private String mode;
    private AioRedisStreamConfig redis;
}
