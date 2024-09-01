package cn.aio1024.framework.basic.discover.domain;

import lombok.Data;

/**
 * @author lizhenming
 * @desc: 模块环境变量
 * @date 2023/12/1 16:38
 */
@Data
public class ModuleEnvironmentVariable {
    /**    */
    private String key;
    private String value;
    private String type;
    private String desc;
}
