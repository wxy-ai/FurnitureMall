package com.ctr.service;

import com.ctr.pojo.User;
import com.ctr.vo.ResponseVo;

public interface UserService {
    // 登录
    ResponseVo<User> login(String username, String password);

    // 注册
    ResponseVo<User> register(User user);
}
