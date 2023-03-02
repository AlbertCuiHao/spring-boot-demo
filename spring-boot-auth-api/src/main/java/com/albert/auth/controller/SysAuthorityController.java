package com.albert.auth.controller;


import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.model.SysAuthorityModel;
import com.albert.auth.service.SysAuthorityService;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Authority管理")
@PreAuthorize("hasRole('ROLE_AUTHORITY')")
@RequestMapping(value = "/authority")
@RestController
@Validated
public class SysAuthorityController {

    private SysAuthorityService sysAuthorityService;

    @Autowired
    public void setSysAuthorityService(SysAuthorityService sysAuthorityService) {
        this.sysAuthorityService = sysAuthorityService;
    }


    @Operation(summary = "查看")
    @GetMapping("/find")
    public ApiModel<ArrayList<SysAuthorityModel>> findSysAuthority() {
        List<SysAuthorityModel> sysAuthorityModelList = sysAuthorityService.findSysAuthority();
        return ApiModel.ok(sysAuthorityModelList, ApiStatus.QUERY_SUCCESS);
    }

    @Operation(summary = "新增")
    @PostMapping("/add")
    public ApiModel<String> addSysAuthority(@RequestBody @Validated SysAuthorityEntity entity) {
        String id = sysAuthorityService.addSysAuthority(entity);
        return ApiModel.success(id, ApiStatus.SAVE_SUCCESS);
    }

    @Operation(summary = "删除")
    @GetMapping("/delete")
    public ApiModel<String> deleteSysAuthorityById(@RequestParam @NotBlank String id) {
        String msg = sysAuthorityService.deleteSysAuthorityById(id);
        return ApiModel.success(msg, ApiStatus.DELETE_SUCCESS);
    }


}
