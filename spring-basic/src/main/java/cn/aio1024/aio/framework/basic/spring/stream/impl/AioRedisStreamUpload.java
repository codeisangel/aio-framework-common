package cn.aio1024.aio.framework.basic.spring.stream.impl;

import com.alibaba.fastjson.JSON;
import cn.aio1024.aio.framework.basic.spring.stream.AbstractAioStreamUpload;
import cn.aio1024.aio.framework.basic.spring.stream.AioStreamUploadConstant;
import cn.aio1024.aio.framework.basic.spring.stream.bo.MessageResult;
import cn.aio1024.aio.framework.basic.spring.stream.bo.StreamMessage;
import cn.aio1024.aio.framework.basic.spring.stream.config.AioSteamMessageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StreamOperations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:23
 */
@Slf4j
public class AioRedisStreamUpload extends AbstractAioStreamUpload {
    public AioRedisStreamUpload(AioSteamMessageProperties messageProperties) {
        super(messageProperties);
    }
    @Autowired
    @Qualifier(AioStreamUploadConstant.REDIS_BEAN_NAME)
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public MessageResult sendBasic(StreamMessage message) {
        Map<String,String> body = new HashMap<>(10);
        body.put("message", JSON.toJSONString(message));

        //创建
        StreamOperations streamOperations = redisTemplate.opsForStream();
        //生产者发送消息  "emailStream"-是消费者配置的Stream队列名称
        RecordId add = streamOperations.add(message.getTopic(),body);
        log.debug("【RedisStream消息上报】上报结果 ： {} | 上报数据 ： {} ",add.getValue(),JSON.toJSONString(body));
        MessageResult result = MessageResult.builder()
                .id(message.getId())
                .success(true)
                .build();
        return result;
    }
}
