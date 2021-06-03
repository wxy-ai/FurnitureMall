package com.ctr.controller;

import com.ctr.service.ProductService;
import com.ctr.vo.ProductDetailVo;
import com.ctr.vo.ProductVo;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize){

        return productService.list(categoryId, pageNum, pageSize);
    }
    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId){
        return productService.detail(productId);
    }
//    @GetMapping("/product/{name}")
//    public ResponseVo<PageInfo<List<ProductDetailVo>>> select(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
//                                                    @RequestParam(required = false, defaultValue = "8") Integer pageSize,
//                                                              @PathVariable String name){
//        PageInfo<List<ProductDetailVo>> pageInfo = productService.selectByProductName(name, pageNum, pageSize);
//        ResponseVo<PageInfo<List<ProductDetailVo>>> pageInfoResponseVo = ResponseVo.successByData(pageInfo);
//
//        return pageInfoResponseVo;
//    }
    @GetMapping("/product/{name}")
    public ResponseVo<PageInfo> select( @PathVariable String name,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "8") Integer pageSize) {

        return productService.selectByProductName(name,pageNum,pageSize);
    }

}
