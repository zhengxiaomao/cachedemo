package com.example.cachedemo.dao;

import com.example.cachedemo.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    @Select("select * from user")
    List<User> queryAll();

    @Select("select * from user where uid = #{id}")
    User findUserById(int id);

    @Update("UPDATE USER SET username = CASE WHEN (#{userName} != NULL) AND (#{userName} != '') THEN #{userName},PASSWORD = CASE WHEN (#{passWord} != NULL) AND (#{passWord} != '') THEN #{passWord},salary = CASE WHEN (#{salary} != 0) THEN #{salary} WHERE uid = #{uid}")
    int updateUser(@Param("user") User user);

    @Delete("delete from user where uid = #{id}")
    int deleteUserById(int id);

}