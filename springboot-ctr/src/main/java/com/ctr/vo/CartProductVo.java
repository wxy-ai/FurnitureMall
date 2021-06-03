package com.ctr.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {
    private Integer productId;
   // 购买得数量
    private Integer quantity;

    private String productName;

    private String productSubtitle;
    // 主图
    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

   // quantity * productPrice
    private BigDecimal productTotalPrice;
    //库存
    private Integer productStock;

   // 是否被选中
    private Boolean productSelected;

    public CartProductVo(Integer productId, Integer quantity, String productName, String productSubtitle, String productMainImage, BigDecimal productPrice, Integer productStatus, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
