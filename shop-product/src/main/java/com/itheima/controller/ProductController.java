package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desription:
 *
 * @ClassName UserController
 * @Author Zhanyuwei
 * @Date 2020/2/23 10:18
 * @Version 1.0
 **/
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 商品信息查询
     */
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询",pid);
        Product product =productService.findByPid(pid);
        log.info("商品信息查询成功，内容为{}", JSON.toJSONString(product));

        return product;
    }

}
