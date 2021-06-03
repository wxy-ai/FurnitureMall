package com.ctr.controller;

import com.ctr.pojo.Product;
import com.ctr.pojo.User;
import com.ctr.service.AdminService;
import com.ctr.vo.AdminResults;
import com.ctr.vo.PageTableRequest;
import com.ctr.vo.Results;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@Slf4j
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // 管理员登录
    @PostMapping("/login")
    @ResponseBody
    public Results AdminLogin(String username, String password){
        return adminService.adminLogin(username, password);
    }
    // 获取用户列表信息，包括分页功能
    @GetMapping("/getAllUser")
    @ResponseBody
    public AdminResults getAllUser(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset(); // 先计算offset
        return adminService.getAllUser(pageTableRequest.getOffset(), pageTableRequest.getLimit());
    }
    // 删除用户
    @PostMapping("/deleteUser")
    @ResponseBody
    public Results deleteUser(int userID){
        return adminService.deleteUser(userID);
    }

    // 添加用户
    @PostMapping("/addUser")
    @ResponseBody
    public Results addUser(String username, String password, String email){
        return adminService.addUser(username, password, email);
    }

    // 修改用户信息
    @PostMapping("/changeUser")
    @ResponseBody
    public Results changeInfo(int userID, User user){
        user.setId(userID);
        return adminService.changeUserInfo(user);
    }

    // 获取所有商品列表，同时分页
    @GetMapping("/getAllShop")
    @ResponseBody
    public AdminResults getAllShop(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset();
        return adminService.getAllShop(pageTableRequest.getOffset(), pageTableRequest.getLimit());
    }

    // 添加商品
    @PostMapping("/addShop")
    @ResponseBody
    public Results addShop(Product product){
        return adminService.addShop(product);
    }


    // 删除商品
    @PostMapping("/deleteShop")
    @ResponseBody
    public Results deleteShop(int shopID){
        return adminService.deleteShop(shopID);
    }

    // 修改商品信息
    @PostMapping("/changeShop")
    @ResponseBody
    public Results changeShop(int shopID, Product product){
        product.setId(shopID);
        return adminService.changeShopInform(product);
    }


    // 获取所有订单列表，同时分页
    @GetMapping("/getAllOrder")
    @ResponseBody
    public AdminResults getAllOrder(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset();
        return adminService.getAllOrder(pageTableRequest.getOffset(), pageTableRequest.getLimit());
    }

    // 修改商品信息
    @PostMapping("/updateOrderStatus")
    @ResponseBody
    public Results updateOrderStatus(Integer orderId){
        return adminService.updateOrderStatus(orderId);
    }

    // 删除订单
    @PostMapping("/deleteOrder")
    @ResponseBody
    public Results deleteOrder(int orderId){
        return adminService.deleteOrder(orderId);
    }


}
