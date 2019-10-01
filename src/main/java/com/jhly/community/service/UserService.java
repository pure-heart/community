package com.jhly.community.service;

import com.jhly.community.mapper.UserMapper;
import com.jhly.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:JHLY
 * @Date:2019/9/19
 * @Description:com.jhly.community.service
 * @Version:1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        //根据account_id判断是否存在
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null){
            //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
        }else{
            //更新
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setBio(user.getBio());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
