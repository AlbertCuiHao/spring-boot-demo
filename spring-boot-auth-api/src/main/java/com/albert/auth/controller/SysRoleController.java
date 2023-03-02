package com.albert.auth.controller;


import com.albert.auth.model.SysRoleModel;
import com.albert.auth.service.SysRoleService;
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

@Tag(name = "Role管理")
@PreAuthorize("hasRole('ROLE_ROLE')")
@RequestMapping(value = "/role")
@RestController
public class SysRoleController {

    private SysRoleService roleService;

    @Autowired
    public void setRoleService(SysRoleService roleService) {
        this.roleService = roleService;
    }


    @Operation(summary = "查看")
    @GetMapping("/find")
    public ApiModel<ArrayList<SysRoleModel>> findSysRole() {
        List<SysRoleModel> sysRoleModelList = roleService.findSysRole();
        return ApiModel.ok(sysRoleModelList, ApiStatus.QUERY_SUCCESS);
    }
}
