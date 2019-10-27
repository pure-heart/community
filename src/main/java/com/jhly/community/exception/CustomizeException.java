package com.jhly.community.exception;

import lombok.Data;

/**
 * 自定义异常类
 *
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.exception
 * @Version:1.0
 */
@Data
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
