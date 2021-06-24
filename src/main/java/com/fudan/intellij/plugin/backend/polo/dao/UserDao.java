package com.fudan.intellij.plugin.backend.polo.dao;

import com.fudan.intellij.plugin.backend.polo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserbyName(String username);

    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    User verifyUser(String username,String password);

    @Select("SELECT * FROM user")
    List<User> findUser();

    @Insert("insert into user(username, password, email, phone) values(#{username}, #{password}, #{email},#{phone})")
    int insertUser(String username, String password, String email,String phone);
}
