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
                model.setAuthorityName(entity.getAuthorityName());
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

    @Override
    public String addSysAuthority(SysAuthorityModel model) {
        String uuid = BaseUtils.getUUID();
        model.setId(uuid);
        model.setCreateBy(SecurityUtils.getUserName());
        model.setUpdateBy(SecurityUtils.getUserName());
        int i = authorityMapper.addSysAuthority(model);
        if (i > 0) {
            return uuid;
        }
        return "";
    }

    @Override
    public String deleteSysAuthorityById(String id) {
        return null;
    }


}
