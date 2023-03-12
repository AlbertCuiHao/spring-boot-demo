package com.albert.auth.service;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.model.SysAuthorityModel;

import java.util.List;

public interface SysAuthorityService {
    List<SysAuthorityModel> findSysAuthority();

    SysAuthorityModel findSysAuthorityById(String id);

    String addSysAuthority(SysAuthorityEntity entity);

    String updateSysAuthority(SysAuthorityEntity entity);

    String deleteSysAuthorityById(String id);


}
