package com.jhly.community.dto;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
@Repository
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
