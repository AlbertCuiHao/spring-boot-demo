package com.albert.auth.service.impl;

import com.albert.auth.entity.SysRoleEntity;
import com.albert.auth.mapper.SysRoleMapper;
import com.albert.auth.model.SysRoleModel;
import com.albert.auth.service.SysRoleService;
import com.albert.common.web.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    private SysRoleMapper sysRoleMapper;

    @Autowired
    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }


    @Override
    public List<SysRoleModel> findSysRole() {
        List<SysRoleModel> endList = new ArrayList<>();
        List<SysRoleEntity> entityList = sysRoleMapper.findSysRole();
        if (!entityList.isEmpty()) {
            for (SysRoleEntity entity : entityList) {
                SysRoleModel model = new SysRoleModel();
                model.setId(entity.getId());
                model.setRoleName(entity.getRoleName());
                model.setVersion(entity.getVersion());
                model.setCreateBy(entity.getCreateBy());
                model.setUpdateBy(entity.getUpdateBy());
                model.setCreateTime(DateTimeUtils.getString(entity.getCreateTime()));
                model.setUpdateTime(DateTimeUtils.getString(entity.getUpdateTime()));
                endList.add(model);
            }
        }
        return endList;
    }
}
