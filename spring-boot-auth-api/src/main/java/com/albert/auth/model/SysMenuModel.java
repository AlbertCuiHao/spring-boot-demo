package com.albert.auth.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;


public class SysMenuModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // 菜单id
    private String id;

    // 菜单名称
    private String name;

    // 菜单顺序
    private int orderNo;

    // 父菜单id
    private String pid;

    // 子菜单
    private List<SysMenuModel> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public List<SysMenuModel> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuModel> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysMenuModel)) {
            return false;
        }
        SysMenuModel that = (SysMenuModel) o;
        return orderNo == that.orderNo &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orderNo, pid, children);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysMenuModel.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("orderNo=" + orderNo)
                .add("pid='" + pid + "'")
                .add("children=" + children)
                .toString();
    }
}
