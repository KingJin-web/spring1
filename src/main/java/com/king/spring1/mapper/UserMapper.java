package com.king.spring1.mapper;

import com.king.spring1.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: spring1
 * @description:
 * @author: King
 * @create: 2021-08-12 13:50
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user values (null,#{name},#{pwd},#{sex},now())")
    public boolean insertUser(String name, String pwd, String sex);

    @Select("select * from user where username = #{name}")
    public List<User> selectByName(String name);

    @Select("select * from user")
    public List<User> selectAll();

    @Delete("delete from user where id = #{id}")
    boolean deleteById(int id);


    @Update("update user set username=#{name},password=#{pwd},gender=#{sex}  where id = #{id}")
    boolean updateById(int id, String name, String pwd, String sex);

    @Select("select * from user where username = #{name} and password=#{pwd}")
    List<User> selectByNameAndPwd(String name, String pwd);
}
