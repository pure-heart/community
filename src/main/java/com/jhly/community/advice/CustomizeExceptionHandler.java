package com.jhly.community.advice;

import com.jhly.community.dto.ResultDTO;
import com.jhly.community.exception.CustomizeErrorCode;
import com.jhly.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常类
 *
 * @Auther:JHLY
 * @Date:2019/10/16
 * @Description:com.jhly.community.advice
 * @Version:1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    Object handle(Throwable ex, Model model, HttpServletRequest request) {

        String contentType = request.getContentType();
        if ("application/json".equals(contentType)){
            //返回json
            if (ex instanceof CustomizeException){
                return ResultDTO.errorOf((CustomizeException) ex);
            }else {
                return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
        }else {
            //跳转错误页面
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
