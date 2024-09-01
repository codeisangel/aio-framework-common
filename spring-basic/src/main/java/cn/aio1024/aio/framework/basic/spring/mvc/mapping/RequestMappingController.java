package cn.aio1024.aio.framework.basic.spring.mvc.mapping;

import cn.aio1024.framework.basic.domain.amis.AmisResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/8/4 14:56
 */
@RestController
@Slf4j
@RequestMapping("aio/framework/basic/spring/mapping")
public class RequestMappingController {
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
    @GetMapping(value = "all",name = "获取系统接口定义")
    public AmisResult getAllRequestMapping(){
        List<HttpApiDefinition> endpoints = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        for (RequestMappingInfo info : handlerMethods.keySet()) {
            HandlerMethod handlerMethod = handlerMethods.get(info);
            HttpApiDefinition apiDefinition = new HttpApiDefinition(info);
            apiDefinition.reflect(handlerMethod);
            endpoints.add(apiDefinition);
        }
        return AmisResult.success(endpoints,"所有服务接口");
    }
}
