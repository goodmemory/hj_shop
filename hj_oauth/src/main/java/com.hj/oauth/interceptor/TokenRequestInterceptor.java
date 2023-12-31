package com.hj.oauth.interceptor;

import com.hj.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author 元敬
 * @Version 1.0
 */
@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        //创建管理员令牌
        String token = AdminToken.create();
        //放入Feign请求头中
        template.header("Authorization","bearer "+token);
    }
}
