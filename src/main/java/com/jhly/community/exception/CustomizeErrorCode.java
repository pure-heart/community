package com.jhly.community.exception;

/**
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.exception
 * @Version:1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你找的问题不在了,要不要换个试试?");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
