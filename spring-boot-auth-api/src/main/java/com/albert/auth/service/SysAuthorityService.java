package com.albert.auth.service;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.model.SysAuthorityModel;

import java.util.List;

public interface SysAuthorityService {
    List<SysAuthorityModel> findSysAuthority();
}
