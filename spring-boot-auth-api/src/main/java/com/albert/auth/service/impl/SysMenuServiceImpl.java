package com.albert.auth.service.impl;

import com.albert.auth.entity.SysMenuEntity;
import com.albert.auth.mapper.SysMenuMapper;
import com.albert.auth.model.SysMenuModel;
import com.albert.auth.service.SysMenuService;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import com.albert.common.web.util.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    private SysMenuMapper sysMenuMapper;

    @Autowired
    public void setSysMenuMapper(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }

    @Override
    public List<SysMenuModel> findSysMenu() {
        List<SysMenuEntity> allSysMenu = sysMenuMapper.findSysMenu();
        //根节点
        List<SysMenuModel> rootSysMenu = new ArrayList<>();
        for (SysMenuEntity temp : allSysMenu) {
            if (Objects.isNull(temp.getPid())) { //根节点
                SysMenuModel sysMenuModel = new SysMenuModel();
                sysMenuModel.setId(temp.getId());
                sysMenuModel.setName(temp.getName());
                sysMenuModel.setOrderNo(temp.getOrderNo());
                sysMenuModel.setPid(temp.getPid());
                rootSysMenu.add(sysMenuModel);
            }
        }
        //为根菜单设置子菜单 getChild是递归调用的
        for (SysMenuModel nav : rootSysMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<SysMenuModel> childList = getChild(nav.getId(), allSysMenu);
            nav.setChildren(childList);//给根节点设置子节点
        }
        rootSysMenu.sort(((o1, o2) -> {
            if (o1.getOrderNo() != o2.getOrderNo()) {
                return o1.getOrderNo() - o2.getOrderNo();
            }
            return 0;
        }));
        return rootSysMenu;
    }

    /**
     * 获取子节点
     *
     * @param id         父节点id
     * @param allSysMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private List<SysMenuModel> getChild(String id, List<SysMenuEntity> allSysMenu) {
        //子菜单
        List<SysMenuModel> childList = new ArrayList<>();
        for (SysMenuEntity temp : allSysMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (id.equals(temp.getPid())) {
                SysMenuModel sysMenuModel = new SysMenuModel();
                sysMenuModel.setId(temp.getId());
                sysMenuModel.setName(temp.getName());
                sysMenuModel.setOrderNo(temp.getOrderNo());
                sysMenuModel.setPid(temp.getPid());
                childList.add(sysMenuModel);
            }
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.isEmpty()) {
            return Collections.emptyList();
        }
        //递归
        for (SysMenuModel nav : childList) {
            nav.setChildren(getChild(nav.getId(), allSysMenu));
        }
        return childList;
    }

    @Override
    public ApiModel<String> deleteSysMenuById(String id) {
        List<SysMenuEntity> sysMenuEntities = sysMenuMapper.findSysMenuByPid(id);
        if (sysMenuEntities.isEmpty()) {
            int i = sysMenuMapper.deleteSysMenuById(id);
            if (i > 0) {
                return ApiModel.success(id);
            } else {
                return ApiModel.fail("删除失败", ApiStatus.DELETE_FAIL);
            }
        } else {
            return ApiModel.fail("存在子菜单无法删除", ApiStatus.DELETE_FAIL);
        }
    }

    @Override
    public ApiModel<String> addSysMenu(SysMenuEntity entity) {
        String uuid = BaseUtils.getUUID();
        entity.setId(uuid);
//        entity.setCreateBy(SecurityUtils.getUserName());
//        entity.setUpdateBy(SecurityUtils.getUserName());
        entity.setCreateBy("System");
        entity.setUpdateBy("System");
        int i = sysMenuMapper.addSysMenu(entity);
        if (i > 0) {
            return ApiModel.success(uuid, ApiStatus.SAVE_SUCCESS);
        }
        return ApiModel.success(uuid, ApiStatus.SAVE_FAIL);
    }
}
