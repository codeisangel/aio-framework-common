package cn.aio1024.aio.framework.basic.spring.actuator;

import cn.aio1024.aio.framework.basic.spring.actuator.filter.ActuatorSecurityFilter;
import cn.aio1024.aio.framework.basic.spring.actuator.properties.AioActuatorProperties;
import cn.aio1024.aio.framework.basic.spring.actuator.token.ActuatorToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.health.HealthProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lzm
 * @desc 监控模块封装
 * @date 2024/07/02
 */
@Configuration
@ConditionalOnClass(value={WebEndpointProperties.class,HealthEndpointProperties.class})
@AutoConfigureAfter(WebEndpointAutoConfiguration.class)
@EnableConfigurationProperties(AioActuatorProperties.class)
@PropertySource("classpath:config/aiosecurity.properties")
@Slf4j
public class AioActuatorConfig {
    private final static String MONITOR_ISSUER = "projectMonitor";
    @Value("${monitor.public-key}")
    private String publicKey;
    public AioActuatorConfig(@Autowired AioActuatorProperties actuatorProperties, @Autowired WebEndpointProperties webEndpointProperties, @Autowired HealthEndpointProperties healthEndpointProperties){
        WebEndpointProperties.Exposure exposure = webEndpointProperties.getExposure();
        Set<String> includeSet = new HashSet<>();
        includeSet.add("*");
        exposure.setInclude(includeSet);
        webEndpointProperties.setBasePath("/aio/monitor/actuator");
        healthEndpointProperties.setShowDetails(HealthProperties.Show.ALWAYS);
    }

    @PostConstruct
    private void initTokenKey(){
        log.info("设置服务监控安全模块，公钥 ： {} ",publicKey);
        ActuatorToken.setPublicKey(publicKey,MONITOR_ISSUER);
    }
    @Bean
    public Filter actuatorSecurityFilter(){
        return new ActuatorSecurityFilter();
    }
}
