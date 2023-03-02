package com.albert.auth.controller;


import com.albert.auth.entity.SysMenuEntity;
import com.albert.auth.model.SysMenuModel;
import com.albert.auth.service.SysMenuService;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "菜单管理")
@RequestMapping(value = "/menu")
@RestController
@Validated
public class SysMenuController {

    private final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
    private SysMenuService sysMenuService;

    @Autowired
    public void setSysMenuService(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @Operation(summary = "查看")
    @GetMapping("/show")
    public ApiModel<ArrayList<SysMenuModel>> findSysMenu() {
        List<SysMenuModel> sysMenuTree = sysMenuService.findSysMenu();
        return ApiModel.ok(sysMenuTree, ApiStatus.QUERY_SUCCESS);
    }

    @Operation(summary = "删除")
    @GetMapping("/delete")
    public ApiModel<String> deleteSysMenuById(@RequestParam @NotBlank String id) {
        return sysMenuService.deleteSysMenuById(id);
    }

    @Operation(summary = "新增")
    @PostMapping("/save")
    public ApiModel<String> addSysMenu(@RequestBody @Validated SysMenuEntity entity) {
        if (logger.isDebugEnabled()) {
            logger.debug(entity.toString());
        }
        return sysMenuService.addSysMenu(entity);
    }
}
