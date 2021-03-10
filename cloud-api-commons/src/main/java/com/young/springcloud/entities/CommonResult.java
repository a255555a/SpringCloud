package com.young.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LiuYang
 * @Date 2021/3/10 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 404 not_found
     * 错误代码
     * 错误信息
     * 数据
     */
    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {

        this(code, message, null);
    }

}
