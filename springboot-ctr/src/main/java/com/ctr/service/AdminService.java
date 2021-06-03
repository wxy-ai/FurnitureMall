package com.ctr.service;

import com.ctr.pojo.Product;
import com.ctr.pojo.User;
import com.ctr.vo.AdminResults;
import com.ctr.vo.Results;

public interface AdminService {
    // 管理员登录
    Results adminLogin(String username, String password);

    // 获取用户列表信息，包括分页功能
    AdminResults getAllUser(Integer offset, Integer limit);

    // 添加用户
    Results addUser(String username, String password, String email);

    // 删除用户
    Results deleteUser(int userID);

    // 修改用户信息
    Results changeUserInfo(User user);

    // 获取所有商品列表，同时分页
    AdminResults getAllShop(Integer offset, Integer limit);

    // 添加商品
    Results addShop(Product product);

    // 删除商品 shopID是product表中的id
    Results deleteShop(int shopID);

    // 修改商品信息
    Results changeShopInform(Product product);

    // 获取所有商品列表，同时分页
    AdminResults getAllOrder(Integer offset, Integer limit);

    Results updateOrderStatus(Integer orderId);

    // 删除商品 shopID是product表中的id
    Results deleteOrder(int orderId);

}
