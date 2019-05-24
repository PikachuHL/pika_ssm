package com.pika.ssm.dao;

import com.pika.ssm.domain.Travellers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 游客的持久层接口
 */
public interface TravellersDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Travellers> findByOrdersId(String ordersId);
}
