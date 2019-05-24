package com.pika.ssm.dao;

import com.pika.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层接口
 */
@Repository
public interface ProductDao {
    // 查询所有
    @Select("select * from product")
    List<Product> findAll();

    // 新增订单
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    // 通过id查询
    @Select("select * from product where id=#{id}")
    Product findById(String id);
}
