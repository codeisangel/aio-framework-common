package cn.aio1024.aio.framework.basic.spring.mvc.mapping;

import lombok.Data;

/**
 * @author lizhenming
 * @desc: 接口参数描述
 * @date 2023/8/12 16:19
 */
@Data
public class HttpApiParamDesc {
    private String name;
    private String parentName;
    private Class clazz;
    private String path;
    /**
     * 字段描述
     */
    private String desc;
    /**
     * 是否必须
     */
    private Boolean required = false;
}
