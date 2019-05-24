package com.pika.ssm.service;

import com.pika.ssm.domain.Orders;

import java.util.List;

/**
 * 订单的业务层接口
 */
public interface OrdersService {

    List<Orders> findAll(int page, int size);

    Orders findById(String id);
}
