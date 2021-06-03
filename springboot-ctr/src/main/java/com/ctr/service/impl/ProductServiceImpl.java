package com.ctr.service.impl;

import com.ctr.dao.ProductMapper;
import com.ctr.enums.ProductSatusEnum;
import com.ctr.enums.ResponseEnum;
import com.ctr.pojo.Product;
import com.ctr.service.CategoryService;
import com.ctr.service.ProductService;
import com.ctr.vo.ProductDetailVo;
import com.ctr.vo.ProductVo;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null){
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = products.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(products);
        pageInfo.setList(productVoList);
        return ResponseVo.successByData(pageInfo);
        //  public ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        //        List<ProductVo> productVoList = new ArrayList<>();//声明别忘了
        //        Set<Integer> categoryIdSet = new HashSet<>();
        //        if (categoryId != null){
        //            categoryService.findSubCategoryId(categoryId,categoryIdSet);
        //            categoryIdSet.add(categoryId);
        //        }
        //        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        //        for (Product product : products) {
        //            ProductVo productVo = new ProductVo();
        //            BeanUtils.copyProperties(product, productVo);
        //            productVoList.add(productVo);
        //        }
        //        return ResponseVo.success(productVoList);
        //    }
    }

    @Override
    public ResponseVo<PageInfo> selectByProductName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productMapper.selectByProductName(name);
        List<ProductVo> productVoList = products.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(products);
        pageInfo.setList(productVoList);
        return ResponseVo.successByData(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product.getStatus().equals(ProductSatusEnum.OFF_SALE) || product.getStatus().equals(ProductSatusEnum.DELETE)){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        return ResponseVo.successByData(productDetailVo);
    }

//    @Override
//    public PageInfo<List<ProductDetailVo>> selectByProductName(String name,Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<Product> products = productMapper.selectByProductName(name);
//        ArrayList<ProductDetailVo> list = new ArrayList<>();
//        for (Product product : products) {
//            ProductDetailVo productDetailVo = new ProductDetailVo();
//            BeanUtils.copyProperties(product, productDetailVo);
//            list.add(productDetailVo);
//        }
//        PageInfo<List<ProductDetailVo>> pageInfo = new PageInfo(list);
//        return pageInfo;
//    }
}
