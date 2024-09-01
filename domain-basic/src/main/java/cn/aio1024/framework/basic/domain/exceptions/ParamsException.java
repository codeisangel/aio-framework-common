package cn.aio1024.framework.basic.domain.exceptions;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 参数异常
 *
 * @author lizhenming
 * @date 2023/6/12
 */
@Data
public class ParamsException extends RuntimeException{

    /***状态编码*/
    private Integer code = 40402;

    public ParamsException(String msg){
        super(msg);

    }
    public ParamsException(){
        super("参数错误");
    }
    public ParamsException(CharSequence template, Object... params){
        super(StrUtil.format(template, params));
    }


}
