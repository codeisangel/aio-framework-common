package cn.aio1024.framework.basic.adapter.user;

import cn.aio1024.framework.basic.integration.user.domain.AioUser;

/**
 * 统一安全适配器
 */
public interface AioSecurityAdapter {
    void removeToken(String token);
    String createToken(AioUser user);
    boolean verifyToken(String token);
    AioUser getTokenInfo(String token);

    boolean verifyPassword(String paasword,String passwordCiphertext,String salt);

    boolean verifyPassword(String paasword,String passwordCiphertext);

    String login(String username,String password);
}
