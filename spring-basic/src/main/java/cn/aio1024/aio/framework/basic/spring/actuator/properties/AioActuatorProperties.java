package cn.aio1024.aio.framework.basic.spring.actuator.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lzm
 * @desc 监控配置属性
 * @date 2024/07/02
 */
@ConfigurationProperties(prefix = "aio.actuator")
@Data
public class AioActuatorProperties {
    /**
     * 数据上报模式，默认为拉模式
     */
    public String schema = "pull";
}
