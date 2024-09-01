package cn.aio1024.aio.framework.basic.spring.stream.bo;

import lombok.Data;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:15
 */
@Data
public class AioRedisStreamConfig {
    private String host;
    private Integer port;
    private String password;
}
