package com.albert.auth.mapper;

import com.albert.auth.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysRoleMapper {
    List<SysRoleEntity> findSysRole();
}
