package com.albert.common.security.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class UserTokenModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;

    private List<SimpleGrantedAuthority> grantedAuthorityList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorityList() {
        return grantedAuthorityList;
    }

    public void setGrantedAuthorityList(List<SimpleGrantedAuthority> grantedAuthorityList) {
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTokenModel that = (UserTokenModel) o;
        return Objects.equals(username, that.username) && Objects.equals(grantedAuthorityList, that.grantedAuthorityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, grantedAuthorityList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserTokenModel.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("grantedAuthorityList=" + grantedAuthorityList)
                .toString();
    }
}
