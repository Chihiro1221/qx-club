package com.qianxun.subject.entity;

import com.qianxun.subject.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 响应封装类
 *
 * @author haonan
 */
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private Boolean success;
    private T data;

    public static <T> Result ok() {
        Result result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    public static <T> Result fail() {
        Result result = new Result<T>();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> Result fail(T data) {
        Result result = new Result<T>();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        result.setData(data);
        return result;
    }
}
