package com.jhly.community.dto;

import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private  String avatar_url;

}
