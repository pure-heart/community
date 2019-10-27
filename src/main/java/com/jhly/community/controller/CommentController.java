package com.jhly.community.controller;

import com.jhly.community.dto.CommentDTO;
import com.jhly.community.dto.ResultDTO;
import com.jhly.community.exception.CustomizeErrorCode;
import com.jhly.community.model.Comment;
import com.jhly.community.model.User;
import com.jhly.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:JHLY
 * @Date:2019/10/19
 * @Description:com.jhly.community.controller
 * @Version:1.0
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(1l);
        comment.setLikeCount(0l);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
