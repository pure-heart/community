package com.jhly.community.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.model
 * @Version:1.0
 */
@Data
@Repository
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
