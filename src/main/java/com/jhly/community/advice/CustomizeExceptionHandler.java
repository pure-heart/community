package com.jhly.community.advice;

import com.jhly.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常界面处理
 *
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.advice
 * @Version:1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model) {
        if (ex instanceof CustomizeException) {
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message", "服务冒烟了,要不你稍后再试试！！！");
        }
        return new ModelAndView("error");
    }
}
