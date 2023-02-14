package com.albert.auth.mapper;

import com.albert.auth.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Albert
 */
@Mapper
public interface SysMenuMapper {
    List<SysMenuEntity> findSysMenu();

    List<SysMenuEntity> findSysMenuByPid(@Param("pid") String pid);

    int deleteSysMenuById(String id);

    int addSysMenu(SysMenuEntity entity);
}
