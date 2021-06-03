package com.ctr.controller;

import com.ctr.consts.MallConst;
import com.ctr.enums.ResponseEnum;
import com.ctr.form.UserLoginForm;
import com.ctr.form.UserRegisterForm;
import com.ctr.pojo.User;
import com.ctr.service.UserService;
import com.ctr.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm){
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return userService.register(user);
    }
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session){
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        // 设置Session
        session.setAttribute(MallConst.CURRENT_USER,userResponseVo.getData());

        return  userResponseVo;
    }
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.successByData(user);
    }
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
