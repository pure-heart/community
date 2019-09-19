package com.jhly.community.dto;

import com.jhly.community.model.User;
import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/9/18
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
