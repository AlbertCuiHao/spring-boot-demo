package com.albert.common.security.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MyOncePerRequestFilter extends OncePerRequestFilter {

    /**
     * 在过滤之前和之后执行的事件
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        String tokenHeader = null;
        if (webApplicationContext != null) {
            tokenHeader = request.getHeader(webApplicationContext.getEnvironment().getProperty("albert.security.token.header"));
        }
        if (Objects.isNull(tokenHeader)) {
            chain.doFilter(request, response);
        } else {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
            chain.doFilter(request, response);
        }
    }


    /**
     * 从token中获取用户信息并新建一个token
     *
     * @param tokenHeader 字符串形式的Token请求头
     * @return 带用户名和密码以及权限的Authentication
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String username = "";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_test"));
        authorities.add(new SimpleGrantedAuthority("ROLE_demo:read"));
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

}
