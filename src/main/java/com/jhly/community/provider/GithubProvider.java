package com.jhly.community.provider;

import com.alibaba.fastjson.JSON;
import com.jhly.community.dto.AccessTokenDTO;
import com.jhly.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.provider
 * @Version:1.0
 */
@Component
public class GithubProvider {

    /**
     * 获取GitHub授权用户的accessToken
     * 通过OKHttp调用github的accessToken接口取得accessToken
     *
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        //okHttp调用接口post请求
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder().url("https://github.com/login/oauth/access_token").post(body).build();
        try (Response response = client.newCall(request).execute()) {
            //try括号内的资源会在try语句结束后自动释放，前提是这些可关闭的资源必须实现 java.lang.AutoCloseable 接口。
            String str = response.body().string();
            String[] split = str.split ("&");
            String token = split[0];
            String toke = token.split("=")[1];
            return toke;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据accessToken取得GitHub授权用户信息
     *通过OKHttp调用github接口取得用户
     * @param accessToken
     * @return
     */
    public GithubUser getUser(String accessToken) {
        //okHttp调用接口get请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessToken).build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
