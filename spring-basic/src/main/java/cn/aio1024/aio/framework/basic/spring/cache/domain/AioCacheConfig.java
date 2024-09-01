package cn.aio1024.aio.framework.basic.spring.cache.domain;

import lombok.Data;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/12/10 18:13
 */
@Data
public class AioCacheConfig<T> {
    /**  缓存方式  */
    private String mode;
    private String name;
    private String desc;
    /**  是否开启  */
    private Boolean enable;
    /**  缓存配置  */
    private T config;
}
