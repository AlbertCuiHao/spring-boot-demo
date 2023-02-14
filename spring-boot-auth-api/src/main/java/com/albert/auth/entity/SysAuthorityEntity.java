package com.albert.auth.entity;

import com.albert.common.web.entity.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;


public class SysAuthorityEntity extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SysAuthorityEntity)) return false;
        if (!super.equals(o)) return false;
        SysAuthorityEntity that = (SysAuthorityEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysAuthorityEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .toString();
    }
}
