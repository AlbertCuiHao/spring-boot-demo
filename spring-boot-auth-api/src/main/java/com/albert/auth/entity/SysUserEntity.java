package com.albert.auth.entity;

import com.albert.common.web.entity.BaseEntity;

import java.util.Objects;
import java.util.StringJoiner;


public class SysUserEntity extends BaseEntity {

    private String id;
    private String userName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysUserEntity that = (SysUserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, userName, password);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysUserEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
