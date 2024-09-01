package cn.aio1024.framework.basic.integration.user;

import cn.aio1024.framework.basic.integration.user.domain.AioUser;

/**
 * @author lzm
 * @desc 统一用户接口
 * @date 2024/03/21
 */
public interface AioUserApi {
    /**
     * 获取当前登录用户
     * @return
     */
    AioUser getCurrentUser();

    /**
     * 根据用户ID获取用户
     * @param userId
     * @return
     */
    AioUser getUserById(String userId);
    AioUser getUserByUsername(String username);
    /**
     * 根据证件号获取用户
     * @param cardNo
     * @return
     */
    AioUser getUserByCardNo(String cardNo);
}
