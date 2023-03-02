package com.albert.auth.mapper;

import com.albert.auth.entity.SysAuthorityEntity;
import com.albert.auth.model.SysAuthorityModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysAuthorityMapper {
    List<SysAuthorityEntity> findSysAuthority();

    int addSysAuthority(SysAuthorityModel entity);
}
