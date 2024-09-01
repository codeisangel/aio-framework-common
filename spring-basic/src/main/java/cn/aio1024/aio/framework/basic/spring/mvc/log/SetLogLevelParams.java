package cn.aio1024.aio.framework.basic.spring.mvc.log;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lizhenming
 * @desc: 设置log级别参数
 * @date 2023/7/12 8:46
 */
@Data
public class SetLogLevelParams {
    @NotBlank(message = "日志级别不能为空")
    private String level;
    @NotBlank(message = "日志名称不能为空")
    private String loggerName;
}
