package com.jhly.community.controller;

import com.jhly.community.dto.CommentDTO;
import com.jhly.community.dto.ResultDTO;
import com.jhly.community.mapper.CommentMapper;
import com.jhly.community.model.Comment;
import com.jhly.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(2002,"未登录不能进行评论，请登录！");
        }
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
