package com.jhly.community.dto;

import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/10/21
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
