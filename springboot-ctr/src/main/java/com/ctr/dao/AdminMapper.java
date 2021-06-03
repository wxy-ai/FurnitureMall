package com.ctr.dao;

import com.ctr.pojo.Order;
import com.ctr.pojo.Product;
import com.ctr.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    @Select("select password from admin where username = #{username} ")
    String getAdminPass(String username);

    // 获取所有用户信息，同时分页
    @Select("select * from mall_user limit #{limit} offset #{offset}")
    List<User> getAllUser(Integer offset, Integer limit);
    // 获取用户总数
    @Select("select count(username) from mall_user ")
    Integer getUserCount();

    // 添加用户
    @Insert("insert into mall_user(username, password, email) values(#{username}, #{password}, #{email})")
    void addUser(String username, String password, String email);

    // 删除用户
    @Delete("delete from mall_user where ID = #{userID} ")
    void deleteUser(int userID);

    // 修改用户数据， 使用的xml文件配置
    void changeUserInfo(User user);

    // 获取商品总数
    @Select("select count(ID) from mall_product")
    Integer getShopCount();


    // 获取所有商品信息，同时分页
    @Select("select * from mall_product limit #{limit} offset #{offset} ")
    List<Product> getAllShop(Integer offset, Integer limit);


    // 添加商品
    @Insert("insert into mall_product(category_id, name, price, main_image, stock, status) values(#{categoryId}, #{name}," +
            " #{price}, #{mainImage}, #{stock}, #{status})")
    void addShop(Product product);


    // 修改商品信息
    void changeShopInform(Product product);

    // 删除商品
    @Delete("delete from mall_product where ID = #{shopID}")
    void deleteShop(int shopID);

    // 获取所有订单信息，同时分页
    @Select("select * from mall_order limit #{limit} offset #{offset} ")
    List<Order> getAllOrder(Integer offset, Integer limit);

    // 获取商品总数
    @Select("select count(ID) from mall_order")
    Integer getOrderCount();

    @Update("update mall_order set status = 40 where id = #{orderId}")
    void updateOrderStatus(Integer orderId);

    // 删除商品
    @Delete("delete from mall_order where id = #{orderId}")
    void deleteOrder(int orderId);
}
