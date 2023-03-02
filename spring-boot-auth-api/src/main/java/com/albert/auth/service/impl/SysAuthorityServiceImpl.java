package com.albert.auth.service.impl;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.mapper.SysAuthorityMapper;
import com.albert.auth.model.SysAuthorityModel;
import com.albert.auth.service.SysAuthorityService;
import com.albert.common.web.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<SysAuthorityModel> endList = new ArrayList<>();
        List<SysAuthorityEntity> sysAuthority = authorityMapper.findSysAuthority();
        if (!sysAuthority.isEmpty()) {
            for (SysAuthorityEntity entity : sysAuthority) {
                SysAuthorityModel model = new SysAuthorityModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
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
