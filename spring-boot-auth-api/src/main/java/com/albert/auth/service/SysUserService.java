package com.albert.auth.service;

import com.albert.auth.model.SysUserModel;

import java.util.List;

public interface SysUserService {
    List<SysUserModel> findSysUser();
}
