package com.pika.ssm.dao;

import com.pika.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * 会员的持久层接口
 */
public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
