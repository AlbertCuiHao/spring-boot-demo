package com.albert.auth.service.impl;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.mapper.SysAuthorityMapper;
import com.albert.auth.model.SysAuthorityModel;
import com.albert.auth.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {
    private SysAuthorityMapper sysAuthorityMapper;

    @Autowired
    public void setSysAuthorityMapper(SysAuthorityMapper sysAuthorityMapper) {
        this.sysAuthorityMapper = sysAuthorityMapper;
    }

    @Override
    public List<SysAuthorityModel> findSysAuthority() {
        List<SysAuthorityModel> endList = new ArrayList<>();
        List<SysAuthorityEntity> sysAuthority = sysAuthorityMapper.findSysAuthority();
        if (!sysAuthority.isEmpty()) {
            for (SysAuthorityEntity entity : sysAuthority) {
                SysAuthorityModel model = new SysAuthorityModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setVersion(entity.getVersion());
                model.setCreateBy(entity.getCreateBy());
                model.setUpdateBy(entity.getUpdateBy());
                DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                model.setCreateTime(pattern.format(entity.getCreateTime()));
                model.setUpdateTime(pattern.format(entity.getUpdateTime()));
                endList.add(model);
            }
        }
        return endList;
    }
}
