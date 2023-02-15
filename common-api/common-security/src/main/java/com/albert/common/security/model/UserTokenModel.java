package com.albert.common.security.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class UserTokenModel {
    private String username;

    private List<String> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTokenModel that = (UserTokenModel) o;
        return Objects.equals(username, that.username) && Objects.equals(roleList, that.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, roleList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserTokenModel.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("roleList=" + roleList)
                .toString();
    }
}
