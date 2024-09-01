package cn.aio1024.aio.framework.basic.spring.stream.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lizhenming
 * @desc: 流消息
 * @date 2023/9/26 22:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StreamMessage {
    private String applicationId;
    private String serviceAddr;
    /**  主题  */
    private String topic;
    private String tag;
    /**  创建时间  */
    private Date createTime;
    private String content;
    /**  消息唯一标识  */
    private String id;
    /**  环境  */
    private String evn;

}
