package com.neuedu.project.dao;

import com.neuedu.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void addUser(User newUser);

    void updateUser(User forUpdate);


//
//    void changePassword(@Param("username") String username,
//                        @Param("newPassword") String newPassword);

    List<User> queryUser(User user);

}
