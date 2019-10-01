package com.jhly.community.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Auther:JHLY
 * @Date:2019/9/9
 * @Description:com.jhly.community.model
 * @Version:1.0
 */
@Data
@Repository
public class Question {
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

}
