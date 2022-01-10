package com.wzz.impl;

import com.wzz.entity.User;
import com.wzz.mapper.UserMapper;
import com.wzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImp implements UserService {
    User user = new User();
    @Autowired
    private UserMapper userMapper;
    /*
     * 判断用户名是否存在
     */
    @Override
    public boolean isExists(String username) {
        User user = userMapper.getUserByName(username);
        if (user==null){
            return false;
        }
        return true;
    }
    /**
     * 注册
     */
    @Override
    public boolean regist(User params) {
       return userMapper.addUser(params);
    }
    /*
     * 登录
     */
    @Override
    public boolean login(String username, String password) {
        //调用dao将user数据添加到hashmap中
        User user = userMapper.getUserByName(username);
        if (user==null){
            return false;
        }
      return  true;
    }
}