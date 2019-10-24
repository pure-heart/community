package com.jhly.community.exception;

/**
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.exception
 * @Version:1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了,要不要换个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后再试"),
    SYS_ERROR(2004,"服务冒烟了,要不你稍后再试试！！！");

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
