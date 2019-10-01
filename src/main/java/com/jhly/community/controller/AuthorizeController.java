package com.jhly.community.controller;

import com.jhly.community.dto.AccessTokenDTO;
import com.jhly.community.dto.GithubUser;
import com.jhly.community.model.User;
import com.jhly.community.provider.GithubProvider;
import com.jhly.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.controller
 * @Version:1.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    //读取配置文件中的参数
    @Value("${github.clint.id}")
    private String clintId;
    @Value("${github.clint.secret}")
    private String clintSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessTokenDTO accessTokenDTO;

    @Autowired
    private User user;

    /**
     * 点击登录访问获取GitHub授权连接
     * https://github.com/login/oauth/authorize?client_id=247b0787132273aa047f&redirect_uri=http://localhost:8887/callback&scope=user&state=1
     * 传入参数client_id、redirect_uri、scope、state
     * client_id：GitHub的OAuth Apps提供
     * redirect_uri：访问完成后跳入的地址
     * scope:获取授权的信息内容
     * 返回获取accessToken所需的参数code
     *
     * @param code
     * @param state
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request, HttpServletResponse response) {
        //存入获取accessToken所需要的参数
        accessTokenDTO.setClient_id(clintId);
        accessTokenDTO.setClient_secret(clintSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        //传入参数获取GitHub授权用户的accessToken
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //根据accessToken取得GitHub授权用户信息
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setBio(githubUser.getBio());
            user.setAvatarUrl(githubUser.getAvatar_url());
            //取得用户信息写入数据库，如果存在则更新信息
            userService.createOrUpdate(user);
            //登陆成功，写cookie，写session
            response.addCookie(new Cookie("token", token));
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
