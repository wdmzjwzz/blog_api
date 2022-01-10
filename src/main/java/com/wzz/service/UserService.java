package com.wzz.service;

import com.wzz.entity.User;

public interface UserService {
    /*
     * 判断用户名是否已经存在
     */
    boolean isExists(String userName);
    /*
     * 注册一个用户
     */
    boolean regist(User params);
    /*
     * 登录
     */
    boolean login(String userName, String password);
}