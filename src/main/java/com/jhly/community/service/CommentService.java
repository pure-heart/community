package com.jhly.community.service;

import com.jhly.community.exception.CustomizeErrorCode;
import com.jhly.community.exception.CustomizeException;
import com.jhly.community.model.Comment;
import org.springframework.stereotype.Service;

/**
 * @Auther:JHLY
 * @Date:2019/10/24
 * @Description:com.jhly.community.service
 * @Version:1.0
 */
@Service
public class CommentService {
    public void insert(Comment comment){
        if (comment.getParentId() ==null||comment.getParentId() == 0){
                throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}
