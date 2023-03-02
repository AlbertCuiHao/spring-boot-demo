package com.albert.auth.controller;


import com.albert.auth.model.SysUserModel;
import com.albert.auth.service.SysUserService;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "User管理")
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value = "/user")
@RestController
public class SysUserController {

    private SysUserService userService;

    @Autowired
    public void setUserService(SysUserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "查询")
    @GetMapping("/find")
    public ApiModel<ArrayList<SysUserModel>> findSysUser() {
        List<SysUserModel> modelList = userService.findSysUser();
        return ApiModel.ok(modelList, ApiStatus.QUERY_SUCCESS);
    }
}
