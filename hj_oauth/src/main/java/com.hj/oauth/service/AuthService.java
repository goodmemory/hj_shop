package com.hj.oauth.service;

import com.hj.oauth.util.AuthToken;

/**
 * @author 元敬
 * @Version 1.0
 */
public interface AuthService {
    /**
     * 用户认证的方法
     * @param name
     * @param password
     * @param clientId
     * @param clientSecret
     * @return
     */
    AuthToken login(String name, String password, String clientId, String clientSecret);
}
