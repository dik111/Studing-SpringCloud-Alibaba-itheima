package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desription:
 *
 * @ClassName OrderServiceImpl
 * @Author Zhanyuwei
 * @Date 2020/2/23 10:19
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
}
