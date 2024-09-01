package cn.aio1024.framework.basic.domain.amis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhenming
 * @desc:
 * @date 2022/4/14 9:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmisResult<T> {
    private Integer status;
    private String msg;
    private T data;
    private String token;
    private String traceId ;
    public boolean isSuccess(){
        if (Integer.valueOf(0).equals(this.status)) {
            return true;
        }
        return false;
    }
    public static AmisResult success(Object data){
        AmisResult amisResult = success();
        amisResult.setData(data);
        return amisResult;
    }

    public static AmisResult success(Object data,String msg){
        AmisResult amisResult = success();
        amisResult.setData(data);
        amisResult.setMsg(msg);
        return amisResult;
    }

    public static AmisResult success(){
        AmisResult amisResult = new AmisResult();
        amisResult.setStatus(0);
        amisResult.setMsg("成功");
        return amisResult;
    }




    public static AmisResult successMsg(String msg){
        AmisResult amisResult = new AmisResult();
        amisResult.setStatus(0);
        amisResult.setMsg(msg);
        return amisResult;
    }
    public static AmisResult fail(String msg){
        return fail(50000, msg,null);
    }
    public static AmisResult fail(Integer code, String msg) {
        return fail(code, msg,null);
    }
    public static AmisResult fail(Integer code, String msg, Object data) {
        AmisResult responseJson = new AmisResult(code, msg, data, null,null);
        return responseJson;
    }


}
