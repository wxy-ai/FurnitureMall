package com.ctr.service.impl;

import com.ctr.dao.UserMapper;
import com.ctr.enums.ResponseEnum;
import com.ctr.pojo.User;
import com.ctr.service.UserService;
import com.ctr.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null){
            // 用户不存
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);

        }
        if (!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            // 密码错误
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        // 用户名或密码错误
        return ResponseVo.successByData(user);
    }

    @Override
    public ResponseVo<User> register(User user) {
        // username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            return ResponseVo.error(ResponseEnum.USER_EXIST);
        }
        // email 不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0){
           return ResponseVo.error(ResponseEnum.EMAIL_ERROR);
        }
        // MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        // 写入数据库
        int res = userMapper.insertSelective(user);
        if (res == 0){
           return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }
}
