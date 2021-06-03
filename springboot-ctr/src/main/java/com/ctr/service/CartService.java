package com.ctr.service;

import com.ctr.form.CartAddForm;
import com.ctr.form.CartUpdateForm;
import com.ctr.pojo.Cart;
import com.ctr.vo.CartVo;
import com.ctr.vo.ResponseVo;

import java.util.List;

public interface CartService {
    ResponseVo<CartVo> add(Integer uid, CartAddForm form);
    ResponseVo<CartVo> list(Integer uid);
    // 更新购物车
    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);
    ResponseVo<CartVo> delete(Integer uid, Integer productId);
    ResponseVo<CartVo> selectAll(Integer uid);
    ResponseVo<CartVo> unSelectAll(Integer uid);
    ResponseVo<Integer> sum(Integer uid);
    List<Cart> listForCart(Integer uid);


}
