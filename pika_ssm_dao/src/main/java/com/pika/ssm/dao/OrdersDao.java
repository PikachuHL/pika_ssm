package com.pika.ssm.dao;

import com.pika.ssm.domain.Member;
import com.pika.ssm.domain.Orders;
import com.pika.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单的持久层接口
 */
@Repository
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select =
                    "com.pika.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll();

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.pika.ssm.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "com.pika.ssm.dao.MemberDao.findById")),
            @Result(column = "id", property = "travellers",many = @Many(select = "com.pika.ssm.dao.TravellersDao.findByOrdersId"))
    })
    Orders findById(String id);
}
