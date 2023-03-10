package com.albert.common.security.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SecurityUtils {
    private SecurityUtils() {
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUserName() {
        Authentication authentication = getAuthentication();
        if (Objects.nonNull(authentication)) {
            return authentication.getName();
        } else {
            return "";
        }
    }

    public static List<String> getAuthorities() {
        List<String> authoritiesList = new ArrayList<>();
        getAuthentication().getAuthorities().forEach(temp -> authoritiesList.add(temp.getAuthority()));
        return authoritiesList;
    }

}
