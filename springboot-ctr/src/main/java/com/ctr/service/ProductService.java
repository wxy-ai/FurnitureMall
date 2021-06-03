package com.ctr.service;

import com.ctr.pojo.Product;
import com.ctr.vo.ProductDetailVo;
import com.ctr.vo.ProductVo;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);
    ResponseVo<PageInfo> selectByProductName(String name, Integer pageNum, Integer pageSize);
    ResponseVo<ProductDetailVo> detail(Integer productId);
//    PageInfo<List<ProductDetailVo>> selectByProductName(String name, Integer pageNum, Integer pageSize);

}
