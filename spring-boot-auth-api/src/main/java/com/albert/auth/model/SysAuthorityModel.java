package com.albert.auth.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;


public class SysAuthorityModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Long version;

    private String createTime;

    private String createBy;

    private String updateTime;

    private String updateBy;

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SysAuthorityModel)) return false;
        SysAuthorityModel that = (SysAuthorityModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(version, that.version) && Objects.equals(createTime, that.createTime) && Objects.equals(createBy, that.createBy) && Objects.equals(updateTime, that.updateTime) && Objects.equals(updateBy, that.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, createTime, createBy, updateTime, updateBy);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysAuthorityModel.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("version=" + version)
                .add("createTime='" + createTime + "'")
                .add("createBy='" + createBy + "'")
                .add("updateTime='" + updateTime + "'")
                .add("updateBy='" + updateBy + "'")
                .toString();
    }
}
