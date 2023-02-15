package com.albert.common.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write("MyLogoutSuccessHandler,logout success");

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        String tokenHeader = null;
        if (webApplicationContext != null) {
            tokenHeader = request.getHeader(webApplicationContext.getEnvironment().getProperty("albert.security.token.header"));
        }
        if (StringUtils.hasText(tokenHeader)) {
            Boolean exist = redisTemplate.hasKey(tokenHeader);
            if (Boolean.TRUE.equals(exist)) {
                redisTemplate.delete(tokenHeader);
            }
        }
    }
}
