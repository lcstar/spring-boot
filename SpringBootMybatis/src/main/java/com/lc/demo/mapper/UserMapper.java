package com.lc.demo.mapper;

import com.lc.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `user` (name,password) VALUES (#{name},#{password})")
    public int insertUser(@Param("name") String name, @Param("password") String password);

    @Select("select * from user")
    public List<User> getUsers();
}
