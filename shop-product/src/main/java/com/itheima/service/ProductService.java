package com.itheima.service;

import com.itheima.domain.Product;

public interface ProductService {

    /**
     * 根据Pid查询商品信息
     * @param pid
     * @return
     */
    Product findByPid(Integer pid);
}
