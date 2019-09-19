package com.jhly.community.mapper;

import com.jhly.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @Auther:JHLY
 * @Date:2019/9/6
 * @Description:com.jhly.community.mapper
 * @Version:1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,bio,avatar_url)values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set name = #{name},token = #{token},gmt_create = #{gmtCreate},gmt_modified = #{gmtModified},bio = #{bio},avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
