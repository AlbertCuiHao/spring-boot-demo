package com.albert.auth.param;


import jakarta.validation.constraints.NotBlank;

import java.util.StringJoiner;

public class SysMenuParam {

    private String id;
    @NotBlank
    private String name;
    @NotBlank
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysMenuParam.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("pid='" + pid + "'")
                .toString();
    }
}