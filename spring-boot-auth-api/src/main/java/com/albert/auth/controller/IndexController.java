package com.albert.auth.controller;


import com.albert.auth.entity.SysMenuEntity;
import com.albert.auth.param.SysMenuParam;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//@Tag(name = "页面初始化")
@RestController
@RequestMapping("/index")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Operation(summary = "ROLE_test")
    @PreAuthorize("hasRole('ROLE_test')")
    @GetMapping("/date")
    public ApiModel<LocalDateTime> dateTest() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = pattern.format(now);
        if (logger.isDebugEnabled()) {
            logger.debug(format);
        }
        LocalDateTime dateTime = LocalDateTime.parse(format, pattern);
        if (logger.isDebugEnabled()) {
            logger.debug(dateTime.toString());
        }
        return ApiModel.success(now, ApiStatus.SUCCESS);
    }

    @Operation(summary = "demo:read")
    @PreAuthorize("hasAuthority('demo:read')")
    @GetMapping("/param")
    public ApiModel<ArrayList<SysMenuEntity>> findAllByEntity(@Validated SysMenuParam param) {
        //List<SysMenuEntity> sysMenuTree = sysMenuService.findAllByEntity(param);
        return ApiModel.ok(Collections.emptyList(), ApiStatus.SUCCESS);
    }

    @GetMapping("/test2")
    public ApiModel<ArrayList<HashMap<String, String>>> test02() {
        List<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("key", "1");
        map1.put("jira", "1235");
        map1.put("status", "open");
        map1.put("odc", "A");
        map1.put("updateTime", "2022-4-5 14:30:00");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("key", "2");
        map2.put("jira", "1255");
        map2.put("status", "open");
        map2.put("odc", "A");
        map2.put("updateTime", "2022-4-6 14:30:00");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("key", "4");
        map3.put("jira", "1265");
        map3.put("status", "open");
        map3.put("odc", "B");
        map3.put("updateTime", "2022-4-6 14:30:00");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return ApiModel.ok(list, ApiStatus.SUCCESS);
    }

}
