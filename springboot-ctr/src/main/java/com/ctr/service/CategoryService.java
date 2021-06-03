package com.ctr.service;


import com.ctr.vo.CategoryVo;
import com.ctr.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    ResponseVo<List<CategoryVo>> selectAll();
    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
