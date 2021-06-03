package com.ctr.service.impl;

import com.ctr.dao.AdminMapper;
import com.ctr.pojo.Product;
import com.ctr.pojo.User;
import com.ctr.service.AdminService;
import com.ctr.vo.AdminResults;
import com.ctr.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Results adminLogin(String username, String password) {
        String adminPassword =  adminMapper.getAdminPass(username);// 先获取老的密码
        if(password.equals(adminPassword)){ // 密码正确
            return new Results(1, "登录成功");
        }else {
            return new Results(0, "账号或密码错误");
        }
    }

    @Override
    public AdminResults getAllUser(Integer offset, Integer limit) {
        return new AdminResults(0, "获取成功", adminMapper.getAllUser(offset, limit), adminMapper.getUserCount());
    }

    @Override
    public Results addUser(String username, String password, String email) {
        adminMapper.addUser(username, DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)), email);
        return new Results(1, "添加成功");
    }

    // 删除用户
    @Override
    public Results deleteUser(int userID) {
        adminMapper.deleteUser(userID);
        return new Results(1, "删除成功");
    }

    // 修改用户信息
    @Override
    public Results changeUserInfo(User user) {
        adminMapper.changeUserInfo(user);
        return new Results(1, "修改用户信息成功");
    }

    // 获取所有商品列表，同时分页
    @Override
    public AdminResults getAllShop(Integer offset, Integer limit) {
        return new AdminResults(0, "获取成功", adminMapper.getAllShop(offset, limit), adminMapper.getShopCount());
    }

    @Override
    public Results addShop(Product product) {
        adminMapper.addShop(product);
        return new Results(1, "添加成功");
    }

    // 删除商品
    @Override
    public Results deleteShop(int shopID) {
        adminMapper.deleteShop(shopID);
        return new Results(1, "删除成功");
    }

    // 修改商品信息
    @Override
    public Results changeShopInform(Product product) {
        adminMapper.changeShopInform(product);
        return new Results(1, "修改成功");
    }

    @Override
    public AdminResults getAllOrder(Integer offset, Integer limit) {
        return new AdminResults(0, "获取成功", adminMapper.getAllOrder(offset, limit), adminMapper.getOrderCount());
    }

    @Override
    public Results updateOrderStatus(Integer orderId) {
        adminMapper.updateOrderStatus(orderId);
        return new Results(1, "发货成功");
    }

    @Override
    public Results deleteOrder(int orderId) {
        adminMapper.deleteOrder(orderId);
        return new Results(1, "删除成功");
    }
}
