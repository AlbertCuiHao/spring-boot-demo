package com.albert.auth.entity;

import com.albert.common.web.entity.BaseEntity;

import java.util.Objects;
import java.util.StringJoiner;


public class SysRoleEntity extends BaseEntity {

    private String id;

    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysRoleEntity that = (SysRoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, roleName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRoleEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("roleName='" + roleName + "'")
                .toString();
    }
}
