package com.jhly.community.mapper;

import com.jhly.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.mapper
 * @Version:1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified)values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

}
