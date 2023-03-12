package com.albert.common.web.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApiModel<T> {

    private boolean status;

    private String code;

    private String msg;

    private T data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ApiModel<T> success(T data) {
        ApiModel<T> result = new ApiModel<>();
        result.setStatus(true);
        result.setCode(ApiStatus.SUCCESS.getCode());
        result.setMsg(ApiStatus.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> ApiModel<T> success(T data, ApiMessage apiMessage) {
        ApiModel<T> result = new ApiModel<>();
        result.setStatus(true);
        result.setCode(apiMessage.getCode());
        result.setMsg(apiMessage.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> ApiModel<ArrayList<T>> ok(List<T> list, ApiMessage apiMessage) {
        ApiModel<ArrayList<T>> result = new ApiModel<>();
        result.setStatus(true);
        result.setCode(apiMessage.getCode());
        result.setMsg(apiMessage.getMsg());
        if (!Objects.isNull(list) && !list.isEmpty()) {
            if (list instanceof ArrayList) {
                result.setData((ArrayList<T>) list);
            }
        } else {
            result.setData(new ArrayList<>(0));
        }
        return result;
    }

    public static <T> ApiModel<T> fail(T data) {
        ApiModel<T> result = new ApiModel<>();
        result.setStatus(false);
        result.setCode(ApiStatus.FAIL.getCode());
        result.setMsg(ApiStatus.FAIL.getCode());
        result.setData(data);
        return result;
    }

    public static <T> ApiModel<T> fail(T data, ApiMessage apiMessage) {
        ApiModel<T> result = new ApiModel<>();
        result.setStatus(false);
        result.setCode(apiMessage.getCode());
        result.setMsg(apiMessage.getMsg());
        result.setData(data);
        return result;
    }
}

