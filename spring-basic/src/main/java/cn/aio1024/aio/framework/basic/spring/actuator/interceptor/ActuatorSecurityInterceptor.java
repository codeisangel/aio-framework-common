package cn.aio1024.aio.framework.basic.spring.actuator.interceptor;

import cn.aio1024.aio.framework.basic.spring.actuator.token.ActuatorToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lzm
 * @desc 监控接口安全拦截器
 * @date 2024/07/02
 */
@Slf4j
public class ActuatorSecurityInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String actuatorToken = request.getHeader("ActuatorToken");
        return ActuatorToken.verify(actuatorToken);
    }
}
