package com.albert.auth.entity;

import com.albert.common.web.entity.BaseEntity;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.util.Objects;
import java.util.StringJoiner;


public class SysMenuEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    // 菜单id
    private String id;

    // 菜单名称
    @NotBlank
    private String name;

    // 菜单顺序
    @NotBlank
    private int orderNo;

    // 父菜单id
    private String pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysMenuEntity that = (SysMenuEntity) o;
        return orderNo == that.orderNo &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(pid, that.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, orderNo, pid);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysMenuEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("orderNo=" + orderNo)
                .add("pid='" + pid + "'")
                .toString();
    }
}
