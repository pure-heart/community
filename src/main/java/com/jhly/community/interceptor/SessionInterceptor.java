package com.jhly.community.interceptor;

import com.jhly.community.mapper.UserMapper;
import com.jhly.community.model.User;
import com.jhly.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/19
 * @Description:com.jhly.community.interceptor
 * @Version:1.0
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        /**
         * 为了防止服务器重启session清空后要重新登陆的情况
         */
        //cookie没内容不做处理
        if (cookies!=null && cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    //如果cookie里存放了token,根据token取得用户信息
                    String token = cookie.getValue();
                    //如果存在，放入session
//                    User user = userMapper.findByToken(token);
//                    if (user != null) {
//                        request.getSession().setAttribute("user", user);
//                    }
                    //切换成mybatis xml模式
                    UserExample example = new UserExample();
                    example.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(example);
                    if (users.size() != 0){
                        request.getSession().setAttribute("user", users.get(0));
                    }
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
