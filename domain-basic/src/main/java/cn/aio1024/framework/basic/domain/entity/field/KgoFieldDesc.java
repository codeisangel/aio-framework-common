package cn.aio1024.framework.basic.domain.entity.field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhenming
 * @desc: 字段描述
 * @date 2023/7/22 21:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KgoFieldDesc {
    private String clazz;
    private Class<?> aClass;
    private String type;
    private String name;
    private String desc;
    private String path;
    /** 父字段   */
    private String parentName;
    private Boolean required = false;
}
