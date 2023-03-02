package com.albert.auth.service.impl;

import com.albert.auth.entity.SysUserEntity;
import com.albert.auth.mapper.SysUserMapper;
import com.albert.auth.model.SysUserModel;
import com.albert.auth.service.SysUserService;
import com.albert.common.web.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper userMapper;

    @Autowired
    public void setUserMapper(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public List<SysUserModel> findSysUser() {
        List<SysUserModel> endList = new ArrayList<>();
        List<SysUserEntity> entityList = userMapper.findSysUser();
        if (!entityList.isEmpty()) {
            for (SysUserEntity entity : entityList) {
                SysUserModel model = new SysUserModel();
                model.setId(entity.getId());
                model.setUserName(entity.getUserName());
                model.setPassword(entity.getPassword());
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
