package cn.aio1024.aio.framework.basic.spring.stream.config;

import cn.hutool.core.util.ObjectUtil;
import cn.aio1024.aio.framework.basic.spring.stream.AioStreamUpload;
import cn.aio1024.aio.framework.basic.spring.stream.AioStreamUploadConstant;
import cn.aio1024.aio.framework.basic.spring.stream.bo.AioRedisStreamConfig;
import cn.aio1024.aio.framework.basic.spring.stream.impl.AioRedisStreamUpload;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:20
 */
@Configuration
@Slf4j
@EnableConfigurationProperties(AioSteamMessageProperties.class)
public class AioRedisStreamMessageConfig {
    @Autowired
    private AioSteamMessageProperties messageProperties;



    @Bean(name = AioStreamUploadConstant.REDIS_BEAN_NAME)
    public RedisTemplate<String, String> redisTemplate () {
        log.info("【构造文件服务Redis缓存】 ");
        if (ObjectUtil.isNull(messageProperties)){
            log.error("【redis消息管道初始化失败】 AioSteamMessageProperties 配置对象为空。");
            return null;
        }
        if (ObjectUtil.isNull(messageProperties.getRedis())){
            log.error("【redis消息管道初始化失败】 AioSteamMessageProperties的Redis 配置对象为空。");
            return null;
        }
        AioRedisStreamConfig redisConfig = messageProperties.getRedis();

        // 创建一个单点的redis配置
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisConfig.getHost(),redisConfig.getPort());
        if (StringUtils.isNotBlank(redisConfig.getPassword())){
            redisStandaloneConfiguration.setPassword(redisConfig.getPassword());
        }
        // 创建一个连接池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(2);
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxWaitMillis(10000);

        // 创建一个客户端构造器
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder
                builder =  LettucePoolingClientConfiguration.builder().
                commandTimeout(Duration.ofMillis(10000));
        builder.shutdownTimeout(Duration.ofMillis(4000));
        // 客户端连接池
        builder.poolConfig(poolConfig);

        // redis链接工程
        LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration,builder.build());
        // 在属性配置后设置（很重要）
        redisConnectionFactory.afterPropertiesSet();
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 在属性配置后设置（很重要）
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public AioStreamUpload aioStreamUpload(){
        return new AioRedisStreamUpload(messageProperties);
    }



}
