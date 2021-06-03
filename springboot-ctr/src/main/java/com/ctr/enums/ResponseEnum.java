package com.ctr.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    SUCCESS(0, "成功"),
    PASSWORD_ERROR(1, "密码错误"),
    USER_EXIST(2, "用户已存在"),
    PARAM_ERROR(3,"参数错误"),
    EMAIL_ERROR(4,"邮箱已存在"),
    NO_LOGIN(10,"用户未登录"),
    ERROR(-1,"服务端错误"),
    USERNAME_OR_PASSWORD_ERROR(11,"用户名或密码错误"),
    PRODUCT_OFF_SALE_OR_DELETE(12,"商品下架或者删除"),
    PRODUCT_NOT_EXIST(13,"商品不存在"),
    PRODUCT_STOCK_ERROR(14,"库存不足"),
    CART_PRODUCT_NOT_EXIST(15,"购物车内该商品不存在"),
    DELETE_SHIPPING_FALI(16,"删除收货地址失败"),
    SHIPPING_NOT_EXIT(17,"收货地址不存在"),
    CART_SELECTED_IS_EMPTY(18,"请至少选择一件商品"),
    ORDER_NOT_EXIST(19,"此订单不存在"),
    ORDER_STATUS_ERROR(20,"订单状态有误"),

    ;
    Integer code;
    String desc;
    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
