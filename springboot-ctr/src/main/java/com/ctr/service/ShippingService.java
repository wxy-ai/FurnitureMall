package com.ctr.service;

import com.ctr.form.ShippingForm;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ShippingService {
    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);
    ResponseVo delete(Integer uid, Integer shippingId);
    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);
    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

}
