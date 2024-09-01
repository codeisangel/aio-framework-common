package cn.aio1024.framework.basic.integration.user;


import com.alibaba.ttl.TransmittableThreadLocal;
import cn.aio1024.framework.basic.integration.user.domain.AioUser;

/**
 * @author lizhenming
 * @desc: 当前用户工具，该对象已经废弃，功能迁移请使用见AioUserApi
 * @date 2023/8/3 17:35
 */
@Deprecated
public class AioCurrentUser {
    private static TransmittableThreadLocal<AioUser> CURRENT_USER= new TransmittableThreadLocal();
    public static AioUser getCurrentUser(){
        return CURRENT_USER.get();
    }
    public static void setCurrentUser(AioUser user){
        CURRENT_USER.set(user);
    }
}
