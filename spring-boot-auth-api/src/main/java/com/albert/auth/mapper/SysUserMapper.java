package com.albert.auth.mapper;

import com.albert.auth.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysUserMapper {
    List<SysUserEntity> findSysUser();
}
