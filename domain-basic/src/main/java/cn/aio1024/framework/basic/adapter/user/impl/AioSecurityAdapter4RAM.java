package cn.aio1024.framework.basic.adapter.user.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.aio1024.framework.basic.adapter.user.AioSecurityAdapter;
import cn.aio1024.framework.basic.integration.user.domain.AioUser;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lzm
 * @desc 内存安全Token模块
 * @date 2024/08/07
 */
public class AioSecurityAdapter4RAM implements AioSecurityAdapter {
    private Map<String,AioUser> user_token_map = new ConcurrentHashMap<>(1000);
    private Map<String,Long> user_token_deadline = new ConcurrentHashMap<>(1000);

    @Override
    public void removeToken(String token) {
        user_token_deadline.remove(token);
        user_token_map.remove(token);
    }

    @Override
    public String createToken(AioUser user) {
        String token = IdUtil.fastSimpleUUID();
        user_token_map.put(token,user);
        Date deadline = DateUtil.offsetDay(new Date(), 2);
        user_token_deadline.put(token,deadline.getTime());
        return token;
    }

    @Override
    public boolean verifyToken(String token) {
        if (StringUtils.isBlank(token)){
            return false;
        }
        Long deadlineTime = user_token_deadline.get(token);
        if (ObjectUtil.isNull(deadlineTime)){
            return false;
        }
        if (deadlineTime < System.currentTimeMillis()){
            user_token_deadline.remove(token);
            user_token_map.remove(token);
            return false;
        }
        return true;
    }

    @Override
    public AioUser getTokenInfo(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        Long deadlineTime = user_token_deadline.get(token);
        if (ObjectUtil.isNull(deadlineTime)){
            return null;
        }
        if (deadlineTime < System.currentTimeMillis()){
            user_token_deadline.remove(token);
            user_token_map.remove(token);
            return null;
        }
        return user_token_map.get(token);
    }

    @Override
    public boolean verifyPassword(String paasword, String passwordCiphertext, String salt) {
        return false;
    }

    @Override
    public boolean verifyPassword(String paasword, String passwordCiphertext) {
        return false;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }
}
