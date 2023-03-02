package com.albert.auth.model;

import java.util.StringJoiner;

public class SysAuthorityModel {

    private String id;

    private String authorityName;

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

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
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
    public String toString() {
        return new StringJoiner(", ", SysAuthorityModel.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("authorityName='" + authorityName + "'")
                .add("version=" + version)
                .add("createTime='" + createTime + "'")
                .add("createBy='" + createBy + "'")
                .add("updateTime='" + updateTime + "'")
                .add("updateBy='" + updateBy + "'")
                .toString();
    }
}
