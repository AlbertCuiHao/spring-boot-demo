package com.albert.common.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("code", "403");
        map.put("msg", "MyAccessDeniedHandler,403");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        try (PrintWriter writer = response.getWriter()) {
            writer.println(new ObjectMapper().writeValueAsString(map));
        }
    }
}
