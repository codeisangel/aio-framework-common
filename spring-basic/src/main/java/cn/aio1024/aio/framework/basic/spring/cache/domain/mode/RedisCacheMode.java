package cn.aio1024.aio.framework.basic.spring.cache.domain.mode;

import lombok.Data;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/12/10 18:18
 */
@Data
public class RedisCacheMode {
    private String host;
    private Integer port;
    private String password;
}
