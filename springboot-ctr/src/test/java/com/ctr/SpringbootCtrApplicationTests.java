package com.ctr;

import com.ctr.dao.CategoryMapper;
import com.ctr.form.CartAddForm;
import com.ctr.form.CartUpdateForm;
import com.ctr.form.ShippingForm;
import com.ctr.service.*;

import com.ctr.vo.CartVo;
import com.ctr.vo.OrderVo;
import com.ctr.vo.ProductDetailVo;
import com.ctr.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringbootCtrApplicationTests {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    private UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private OrderService orderService;
    @Test
    public void contextLoads() {
        //注册
//        User user = new User("ctr","6731232106","673132106@qq.com");
//        userService.register(user);


//        HashSet<Integer> set = new HashSet<>();
//        categoryService.findSubCategoryId(100001, set);
//        log.info("set=" + set);

//        productService.list(null,2,1);

       // productService.detail(26);


//        CartAddForm cartAddForm = new CartAddForm();
//        cartAddForm.setProductId(28);
//        cartAddForm.setSelected(true);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        ResponseVo<CartVo> add = cartService.add(1, cartAddForm);
//        log.info("list" + gson.toJson(add));


//        ResponseVo<CartVo> list = cartService.list(1);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("list" + gson.toJson(list));


//        CartUpdateForm cartUpdateForm = new CartUpdateForm();
//        cartUpdateForm.setQuantity(5);
//        cartUpdateForm.setSelected(false);
//        ResponseVo<CartVo> update = cartService.update(1, 26, cartUpdateForm);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("list" + gson.toJson(update));

//        ResponseVo<CartVo> responseVo = cartService.delete(1, 29);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(responseVo));

//        ResponseVo<CartVo> responseVo = cartService.unSelectAll(1);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(responseVo));

//        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(responseVo));

//        ResponseVo<Integer> sum = cartService.sum(1);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(sum));

//        ShippingForm shippingForm = new ShippingForm();
//        shippingForm.setReceiverName("陈陶然");
//        shippingForm.setReceiverAddress("五华");
//        shippingForm.setReceiverCity("梅州");
//        shippingForm.setReceiverMobile("18406656110");
//        shippingForm.setReceiverPhone("012");
//        shippingForm.setReceiverDistrict("白云区");
//        shippingForm.setReceiverProvince("广东省");
//        shippingForm.setReceiverZip("514400");
//        ResponseVo<Map<String, Integer>> add = shippingService.add(1, shippingForm);
//        log.info("result" + add);

//        Integer shippingId = 5;
////        ResponseVo delete = shippingService.delete(1, shippingId);
////        log.info("res" + delete);

        // 测试更新收货地址
//        ShippingForm shippingForm = new ShippingForm();
//        shippingForm.setReceiverName("陈陶然2");
//        shippingForm.setReceiverAddress("五华");
//        shippingForm.setReceiverCity("梅州");
//        shippingForm.setReceiverMobile("18406656110");
//        shippingForm.setReceiverPhone("012");
//        shippingForm.setReceiverDistrict("白云区");
//        shippingForm.setReceiverProvince("广东省");
//        shippingForm.setReceiverZip("514400");
//        ResponseVo update = shippingService.update(1, 6, shippingForm);
//        log.info("res" + update);


//        ResponseVo<PageInfo> list = shippingService.list(1, 1, 10);
//        log.info("res" + list);
//        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(1, 6);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(orderVoResponseVo));
//        ResponseVo<PageInfo> list = orderService.list(1, 1, 1);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        log.info("result=>" + gson.toJson(list));

        ResponseVo<PageInfo> pageInfoResponseVo = productService.selectByProductName("美", 1, 3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("result=>" + gson.toJson( pageInfoResponseVo));
    }


}
