package com.albert.common.web.entity;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // version
    private Long version;

    // create_time
    private LocalDateTime createTime;

    // create_by
    private String createBy;

    // updateTime
    private LocalDateTime updateTime;

    // update_by
    private String updateBy;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
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
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(getVersion(), that.getVersion())
                && Objects.equals(getCreateTime(), that.getCreateTime())
                && Objects.equals(getCreateBy(), that.getCreateBy())
                && Objects.equals(getUpdateTime(), that.getUpdateTime())
                && Objects.equals(getUpdateBy(), that.getUpdateBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVersion(), getCreateTime(), getCreateBy(), getUpdateTime(), getUpdateBy());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseEntity.class.getSimpleName() + "[", "]")
                .add("version=" + version)
                .add("createTime=" + createTime)
                .add("createBy='" + createBy + "'")
                .add("updateTime=" + updateTime)
                .add("updateBy='" + updateBy + "'")
                .toString();
    }
}
