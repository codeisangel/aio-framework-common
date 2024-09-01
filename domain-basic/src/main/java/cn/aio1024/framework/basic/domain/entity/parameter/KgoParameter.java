package cn.aio1024.framework.basic.domain.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/7/22 21:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KgoParameter {
    private String name;
    private String clazz;
    private Class aClass;
    private String desc;
    private String type;
    private Boolean required = false;
}
