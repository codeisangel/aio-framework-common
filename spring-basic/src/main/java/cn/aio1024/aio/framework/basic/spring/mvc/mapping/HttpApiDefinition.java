package cn.aio1024.aio.framework.basic.spring.mvc.mapping;

import cn.aio1024.framework.basic.domain.entity.field.KgoFieldDesc;
import cn.aio1024.framework.basic.domain.utils.reflect.KgoFieldUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/8/11 8:40
 */
@Data
@NoArgsConstructor
@Slf4j
public class HttpApiDefinition {
    private Set<String> urls;
    private Set<RequestMethod> methods;
    private String name;
    private MethodDesc methodDesc;
    private List<KgoFieldDesc> params = new ArrayList<>();


    public HttpApiDefinition(RequestMappingInfo info){
        this.urls = info.getPatternsCondition().getPatterns();
        this.methods = info.getMethodsCondition().getMethods();
        this.name = info.getName();
    }
    public void reflect(HandlerMethod handlerMethod){
        methodDesc = new MethodDesc(handlerMethod.getMethod().getName(),handlerMethod.getBeanType());
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();

        for (MethodParameter methodParameter : methodParameters) {
            Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
            log.info("方法名 ： {}  | 方法注解 ： {} ",methodParameter.getParameterName(),parameterAnnotations);
            for (Annotation parameterAnnotation : parameterAnnotations) {
                if (parameterAnnotation instanceof ModelAttribute){
                    ModelAttribute modelAttribute = (ModelAttribute) parameterAnnotation;
                    String name = modelAttribute.name();
                    log.info("ModelAttribute 参数名 ： {} ",name);
                }
                if (parameterAnnotation instanceof RequestParam){
                    RequestParam requestParam = (RequestParam) parameterAnnotation;
                    String name = requestParam.name();
                    boolean required = requestParam.required();
                    log.info("RequestParam 参数名 ： {}  | 是否必须 {} ",name,required);
                }
            }
            List<KgoFieldDesc> fieldList = new ArrayList<>();
            KgoFieldUtils.parseClassFields(fieldList,methodParameter.getParameterType(),null);
            params.addAll(fieldList);
        }
    }
}
