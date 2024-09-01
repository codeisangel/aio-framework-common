package cn.aio1024.aio.framework.basic.spring.stream;

import cn.aio1024.aio.framework.basic.spring.stream.bo.MessageResult;
import cn.aio1024.aio.framework.basic.spring.stream.bo.StreamMessage;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:01
 */
public interface AioStreamUpload {
    MessageResult send(StreamMessage message);
    MessageResult send(String topic,String tag,Object body);
    MessageResult send(String topic,Object body);
}
