package cn.aio1024.aio.framework.basic.spring.actuator.filter;

import cn.aio1024.aio.framework.basic.spring.actuator.token.ActuatorToken;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lzm
 * @desc 监控接口安全过滤器
 * @date 2024/07/02
 */
public class ActuatorSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 检查是否是 Actuator 请求
        if (httpRequest.getRequestURI().startsWith("/aio/monitor/actuator")) {
            String actuatorToken = httpRequest.getHeader("ActuatorToken");
            boolean verify = ActuatorToken.verify(actuatorToken);
            if (!verify){
                throw new RuntimeException("访问监控接口权限校验失败");
            }
        }

        chain.doFilter(request, response);
    }

    // 可以实现 init() 和 destroy() 方法
}
