package com.ctr.vo;

import lombok.Data;

import java.util.List;

// 分类
@Data
public class CategoryVo {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer sortOrder;
    // 递归
    private List<CategoryVo> subCategories;
}
