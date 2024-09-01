package cn.aio1024.framework.basic.discover;

import cn.aio1024.framework.basic.discover.domain.ModuleDetails;
import cn.aio1024.framework.basic.discover.domain.ModuleEnvironmentVariable;

import java.util.List;

/**
 * @author lizhenming
 * @desc: 服务发现接口
 * @date 2023/12/1 15:58
 */
public interface AioDiscover {
    /**
     * 获取版本号
     */
    String getVersion();
    /**
     * 获取模块信息
     *
     * @return cn.aio1024.framework.basic.discover.domain.ModuleDetails
     **/
    ModuleDetails getDetails();
    /**
     * 获取模块可配置的环境变量列表
     *
     * @return java.util.List<cn.aio1024.framework.basic.discover.domain.ModuleEnvironmentVariable>
     **/
    List<ModuleEnvironmentVariable> getEnvironmentVariables();

}
