package cn.aio1024.framework.basic.integration.user;


import cn.aio1024.framework.basic.integration.user.domain.AioUser;

/**
 * @author lizhenming
 * @desc: 用户集成
 * @date 2023/6/19 16:07
 */
public class AioUserUtils {

    public static AioUser getUser() {
        return AioCurrentUser.getCurrentUser();
    }
}
