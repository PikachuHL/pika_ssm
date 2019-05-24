package com.pika.ssm.service;

import com.pika.ssm.domain.Product;

import java.util.List;

/**
 * 业务层接口
 */
public interface ProductService {
    // 查询所有
    public List<Product> findAll();

    void save(Product product);
}
