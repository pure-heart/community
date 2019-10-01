package com.jhly.community.controller;

import com.jhly.community.dto.PaginationDTO;
import com.jhly.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**首页展示
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.controller
 * @Version:1.0
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size,
                        Model model) {
        PaginationDTO pagination =questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
