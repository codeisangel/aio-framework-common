package cn.aio1024.framework.basic.domain.trace;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author lzm
 * @desc 追踪码
 * @date 2024/05/11
 */
public class TraceId {
    public static TransmittableThreadLocal<String> logTraceID = new TransmittableThreadLocal();
    public static void setTraceId(String traceId){
        logTraceID.set(traceId);
    }
    public static  String getTraceId(){
        return logTraceID.get();
    }


}
