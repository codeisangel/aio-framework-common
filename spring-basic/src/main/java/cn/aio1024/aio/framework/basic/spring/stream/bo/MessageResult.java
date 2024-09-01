package cn.aio1024.aio.framework.basic.spring.stream.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/9/26 22:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResult {
    private String id;
    private Boolean success;
    private String modeId;
    private String msg;
}
