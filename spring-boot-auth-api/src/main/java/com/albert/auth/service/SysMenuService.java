package com.albert.auth.service;

import com.albert.auth.entity.SysMenuEntity;
import com.albert.auth.model.SysMenuModel;
import com.albert.common.web.result.ApiModel;

import java.util.List;

public interface SysMenuService {
    List<SysMenuModel> findSysMenu();

    ApiModel<String> deleteSysMenuById(String id);

    ApiModel<String>  addSysMenu(SysMenuEntity entity);
}
