package cn.aio1024.aio.framework.basic.spring.mvc.log;

import cn.aio1024.framework.basic.domain.amis.AmisResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/7/12 8:42
 */
@RestController
@Slf4j
@RequestMapping("aio/framework/log/level")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogLevelController {
    private final LoggingSystem loggingSystem;

    /**
     * 动态设置日志级别
     *
     * @param params: 设置日志级别参数
     * @return cn.aio1024.flow.common.domain.amis.AmisResult
     **/
    @PostMapping()
    public AmisResult setLogLevel(@RequestBody @Validated SetLogLevelParams params) {
        LogLevel logLevel = null;
        if (StringUtils.equalsIgnoreCase(params.getLevel(), LogLevel.DEBUG.name())){
            logLevel = LogLevel.DEBUG;
        }else if (StringUtils.equalsIgnoreCase(params.getLevel(), LogLevel.INFO.name())){
            logLevel = LogLevel.INFO;
        }else if (StringUtils.equalsIgnoreCase(params.getLevel(), LogLevel.WARN.name())){
            logLevel = LogLevel.WARN;
        }else if (StringUtils.equalsIgnoreCase(params.getLevel(), LogLevel.ERROR.name())){
            logLevel = LogLevel.ERROR;
        }
        if (ObjectUtils.isEmpty(logLevel)){
            return AmisResult.fail("未设置正确的日志级别");
        }
        loggingSystem.setLogLevel(params.getLoggerName(), logLevel);
        return AmisResult.successMsg("日志级别修改成功");
    }
    /**
     * 获取日志级别
     *
     * @param loggerName:
     * @return cn.aio1024.flow.common.domain.amis.AmisResult
     **/
    @GetMapping()
    public AmisResult getLevel(@RequestParam String loggerName) {
        LoggerConfiguration loggerConfiguration = loggingSystem.getLoggerConfiguration(loggerName);
        return AmisResult.success(loggerConfiguration);
    }
}
