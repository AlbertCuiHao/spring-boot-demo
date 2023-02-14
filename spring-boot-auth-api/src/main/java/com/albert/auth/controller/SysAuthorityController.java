package com.albert.auth.controller;


import com.albert.auth.model.SysAuthorityModel;
import com.albert.auth.service.SysAuthorityService;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Authority管理")
//@PreAuthorize("hasRole('ROLE_manager')")
@RestController
@RequestMapping(value = "/authority")
@Validated
public class SysAuthorityController {

    private SysAuthorityService sysAuthorityService;

    @Autowired
    public void setSysAuthorityService(SysAuthorityService sysAuthorityService) {
        this.sysAuthorityService = sysAuthorityService;
    }


    @Operation(summary = "查看")
    @GetMapping("/findAll")
    public ApiModel<ArrayList<SysAuthorityModel>> findSysMenu() {
        List<SysAuthorityModel> sysAuthority = sysAuthorityService.findSysAuthority();
        return ApiModel.ok(sysAuthority, ApiStatus.QUERY_SUCCESS);
    }
}
