package com.ctr.interceptor;


import com.ctr.consts.MallConst;
import com.ctr.enums.ResponseEnum;
import com.ctr.exception.UserLoginException;
import com.ctr.pojo.User;
import com.ctr.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 拦截器
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle..");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null){
            log.info("user=null");
            throw new UserLoginException();
            // return ResponseVo.error(ResponseEnum.NO_LOGIN);
        }
        return true;
    }

}
