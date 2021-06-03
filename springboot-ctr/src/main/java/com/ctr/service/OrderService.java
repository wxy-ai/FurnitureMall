package com.ctr.service;

import com.ctr.vo.OrderVo;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface OrderService {
    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);
    ResponseVo cancel(Integer uid, Long orderNo);
    ResponseVo<OrderVo> update(Integer uid, Long orderNo);
}
