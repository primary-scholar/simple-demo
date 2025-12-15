package com.mimu.simple.java.seriali;

public class ApiResultUtil {

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(data);
        result.setCode(1);
        result.setMessage("success");
        return result;
    }
}
