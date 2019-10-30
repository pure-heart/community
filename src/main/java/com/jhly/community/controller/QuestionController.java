package com.jhly.community.controller;

import com.jhly.community.dto.QuestionDTO;
import com.jhly.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther:JHLY
 * @Date:2019/9/19
 * @Description:com.jhly.community.controller
 * @Version:1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //累加评论
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
