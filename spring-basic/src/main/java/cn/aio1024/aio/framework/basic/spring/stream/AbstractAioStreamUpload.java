package cn.aio1024.aio.framework.basic.spring.stream;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.aio1024.aio.framework.basic.spring.stream.bo.MessageResult;
import cn.aio1024.aio.framework.basic.spring.stream.bo.StreamMessage;
import cn.aio1024.aio.framework.basic.spring.stream.config.AioSteamMessageProperties;
import cn.aio1024.framework.basic.domain.utils.reflect.TypeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:10
 */
public abstract class AbstractAioStreamUpload implements AioStreamUpload {
    private final AioSteamMessageProperties messageProperties;

    public AbstractAioStreamUpload(AioSteamMessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }
    public abstract MessageResult sendBasic(StreamMessage message);
    @Override
    public MessageResult send(StreamMessage message){
        if (ObjectUtil.isNull(message)){
            message = new StreamMessage();
        }
        if (StringUtils.isBlank(message.getApplicationId())){
            message.setApplicationId(messageProperties.getApplicationId());
        }
        if (StringUtils.isBlank(message.getServiceAddr())){
            message.setServiceAddr(messageProperties.getServiceAddr());
        }
        if (StringUtils.isBlank(message.getId())){
            message.setId(IdUtil.getSnowflakeNextIdStr());
        }
        if (ObjectUtil.isNull(message.getCreateTime())){
            message.setCreateTime(new Date());
        }
        return sendBasic(message);
    }

    @Override
    public MessageResult send(String topic, String tag, Object body) {

        String content =  TypeUtils.getTypeStr(body);
        StreamMessage build = StreamMessage.builder()
                .applicationId(messageProperties.getApplicationId())
                .serviceAddr(messageProperties.getServiceAddr())
                .topic(topic)
                .tag(tag)
                .content(content)
                .createTime(new Date())
                .id(IdUtil.getSnowflakeNextIdStr()).build();
        return send(build);
    }

    @Override
    public MessageResult send(String topic, Object body) {
        return send(topic,null,body);
    }
}
