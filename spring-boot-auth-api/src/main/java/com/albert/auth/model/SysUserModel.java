package com.albert.auth.model;

import java.util.StringJoiner;

public class SysUserModel {

    private String id;

    private String userName;

    private String password;

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
        return new StringJoiner(", ", SysUserModel.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("version=" + version)
                .add("createTime='" + createTime + "'")
                .add("createBy='" + createBy + "'")
                .add("updateTime='" + updateTime + "'")
                .add("updateBy='" + updateBy + "'")
                .toString();
    }
}
