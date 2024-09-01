package cn.aio1024.aio.framework.basic.spring.mvc.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/8/11 8:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodDesc {
    private String methodName;
    private Class clazz;

}
