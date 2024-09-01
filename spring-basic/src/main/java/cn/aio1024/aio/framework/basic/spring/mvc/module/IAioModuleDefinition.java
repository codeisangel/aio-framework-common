package cn.aio1024.aio.framework.basic.spring.mvc.module;

/**
 * @author lizhenming
 * @desc: 模块定义
 * @date 2023/8/7 19:21
 */
public interface IAioModuleDefinition {
    /**
     * 获取模块配置
     *
     * @return cn.aio1024.aio.framework.basic.spring.mvc.module.AioModuleConfig
     **/
    AioModuleConfig getInfo();
    /**
     * 获取运维配置
     *
     * @return cn.aio1024.aio.framework.basic.spring.mvc.module.AioModuleConfig
     **/
    AioModuleConfig getOpsConfig();
}
