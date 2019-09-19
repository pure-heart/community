package com.jhly.community.model;

import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.model
 * @Version:1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String bio;
    private String avatarUrl;

}
