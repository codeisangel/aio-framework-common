package cn.aio1024.framework.basic.discover.domain;

import lombok.Data;

/**
 * @author lizhenming
 * @desc: 模块信息
 * @date 2023/12/1 16:02
 */
@Data
public class ModuleDetails {
    /**
     * 模块名称
     */
    private String name;
    /**
     * 模块描述
     */
    private String desc;
    /**
     * 运维地址
     */
    private String opsUrl;
    /**
     * 模块标识
     */
    private String tag;
    private String version;
    /**
     * logo
     */
    private String logo;
}
