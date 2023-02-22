package com.albert.common.security.handler;

import com.albert.common.security.model.UserTokenModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String name = authentication.getName();
        List<String> authoritiesList = new ArrayList<>();
        authentication.getAuthorities().forEach(temp -> authoritiesList.add(temp.getAuthority()));
        UserTokenModel model = new UserTokenModel();
        model.setUsername(name);
        model.setRoleList(authoritiesList);
        redisTemplate.opsForValue().set(name, model);

        HashMap<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("code", "200");
        map.put("msg", "onAuthenticationSuccess,登陆成功");
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = response.getWriter();
        writer.println(new ObjectMapper().writeValueAsString(map));
        writer.close();
        response.setStatus(HttpStatus.OK.value());
        response.flushBuffer();
    }
}
