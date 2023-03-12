package com.albert.auth.service.impl;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.mapper.SysAuthorityMapper;
import com.albert.auth.model.SysAuthorityModel;
import com.albert.auth.service.SysAuthorityService;
import com.albert.common.security.utils.SecurityUtils;
import com.albert.common.web.util.BaseUtils;
import com.albert.common.web.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {
    private SysAuthorityMapper authorityMapper;

    @Autowired
    public void setAuthorityMapper(SysAuthorityMapper authorityMapper) {
        this.authorityMapper = authorityMapper;
    }

    @Override
    public List<SysAuthorityModel> findSysAuthority() {
        List<SysAuthorityModel> modelList = new ArrayList<>();
        List<SysAuthorityEntity> entityList = authorityMapper.findSysAuthority();
        if (!entityList.isEmpty()) {
            for (SysAuthorityEntity entity : entityList) {
                modelList.add(entityToModel(entity));
            }
        }
        return modelList;
    }

    @Override
    public SysAuthorityModel findSysAuthorityById(String id) {
        SysAuthorityEntity entity = authorityMapper.findSysAuthorityById();
        return entityToModel(entity);
    }

    @Override
    public String addSysAuthority(SysAuthorityEntity entity) {
        String uuid = BaseUtils.getUUID();
        entity.setId(uuid);
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreateBy(SecurityUtils.getUserName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdateBy(SecurityUtils.getUserName());
        int i = authorityMapper.addSysAuthority(entity);
        if (i > 0) {
            return uuid;
        }
        return "";
    }

    @Override
    public String updateSysAuthority(SysAuthorityEntity entity) {
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdateBy(SecurityUtils.getUserName());
        int i = authorityMapper.updateSysAuthority(entity);
        if (i > 0) {
            return entity.getId();
        }
        return "";
    }

    @Override
    public String deleteSysAuthorityById(String id) {
        int i = authorityMapper.deleteSysAuthorityById(id);
        if (i > 0) {
            return id;
        }
        return "";
    }

    public SysAuthorityModel entityToModel(SysAuthorityEntity entity) {
        SysAuthorityModel model = new SysAuthorityModel();
        model.setId(entity.getId());
        model.setAuthorityName(entity.getAuthorityName());
        model.setVersion(entity.getVersion());
        model.setCreateBy(entity.getCreateBy());
        model.setUpdateBy(entity.getUpdateBy());
        model.setCreateTime(DateTimeUtils.getString(entity.getCreateTime()));
        model.setUpdateTime(DateTimeUtils.getString(entity.getUpdateTime()));
        return model;
    }

}
