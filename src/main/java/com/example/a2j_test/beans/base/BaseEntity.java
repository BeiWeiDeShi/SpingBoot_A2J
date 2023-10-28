package com.example.a2j_test.beans.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data                   // Getter和Setter方法
@AllArgsConstructor     // 全参数构造
@NoArgsConstructor      // 空参数构造
@Builder                // 构建
public class BaseEntity<T> implements Serializable {
    private T data;     // 数据源
    private boolean success; // 请求是否成功
    private int code;   // 响应码
    private String error; // 错误提示

    // 请求成功
    public static <T> BaseEntity<T> success(T t) {
        BaseEntity<T> base = new BaseEntity<>();
        base.setCode(200);
        base.setData(t);
        base.setSuccess(true);
        return base;
    }

    // 请求 failure
    public static <T> BaseEntity<T> failed(String error) {
        return failed(606, error);
    }

    public static <T> BaseEntity<T> failed(int code, String error) {
        BaseEntity<T> base = new BaseEntity<>();
        base.setCode(code);
        base.setData(null);
        base.setSuccess(false);
        base.setError(error);
        return base;
    }

}
