package com.jhly.community.dto;

import lombok.Data;

/**
 * @Auther:JHLY
 * @Date:2019/10/22
 * @Description:com.jhly.community.dto
 * @Version:1.0
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }
}
