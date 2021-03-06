package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 下单
     * @return
     */
    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("接收到{}号商品的下单请求，接下来调用商品微服务查询此商品信息",pid);

        //调用商品微服务，查询商品信息
        Product product = restTemplate.getForObject("http://service-product/product/"+pid,Product.class);

        log.info("查询到{}号商品的信息，内容是{}",pid, JSON.toJSONString(product));

        //下单
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.createOrder(order);

        log.info("创建订单成功，订单信息为{}",JSON.toJSONString(order));

        return order;
    }

}
