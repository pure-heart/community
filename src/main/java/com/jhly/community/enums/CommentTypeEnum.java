package com.jhly.community.enums;

/**
 * @Auther:JHLY
 * @Date:2019/10/24
 * @Description:com.jhly.community.enums
 * @Version:1.0
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
