package com.jhly.community.controller;

import com.jhly.community.dto.CommentDTO;
import com.jhly.community.mapper.CommentMapper;
import com.jhly.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:JHLY
 * @Date:2019/10/19
 * @Description:com.jhly.community.controller
 * @Version:1.0
 */
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO) {
        Comment record = new Comment();
        record.setParentId(commentDTO.getParentId());
        record.setContent(commentDTO.getContent());
        record.setType(commentDTO.getType());
        record.setGmtModified(System.currentTimeMillis());
        record.setGmtCreate(System.currentTimeMillis());
        record.setCommentator(1);
        record.setLikeCount(0l);
        commentMapper.insert(record);
        return null;
    }
}
