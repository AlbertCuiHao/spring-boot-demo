package com.albert.auth.mapper;

import com.albert.auth.entity.SysAuthorityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysAuthorityMapper {
    List<SysAuthorityEntity> findSysAuthority();

    SysAuthorityEntity findSysAuthorityById();

    int addSysAuthority(SysAuthorityEntity entity);

    int updateSysAuthority(SysAuthorityEntity entity);

    int deleteSysAuthorityById(String id);


}
