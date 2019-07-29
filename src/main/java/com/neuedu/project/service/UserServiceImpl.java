package com.neuedu.project.service;


import com.neuedu.project.dao.UserMapper;
import com.neuedu.project.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * delegate to UserMapper to implement all functions.
     */
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
                    UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void changeName(User forChangingName)
            throws DataAccessException {
//        User forChangeName = new User();
//        forChangeName.setUserId(userId);
//        forChangeName.setName(newName);
        userMapper.updateUser(forChangingName);
    }

    @Override
    public boolean changePassword(User user, String newPassword)
            throws DataAccessException {

        if (userMapper.queryUser(user).size() == 1) {
            User forChangePassword = new User();
            forChangePassword.setUserId(user.getUserId());
            forChangePassword.setPassword(newPassword);
            userMapper.updateUser(forChangePassword);

            return true;
        }
        return false;


    }

    @Override
    public void register(String userId,
                         String password,
                         String name,
                         int identity) throws DataAccessException {
        User newUser = new User(userId, password, name, identity);
//        userMapper.addUser(newUser);
        throw new UnsupportedOperationException();
    }

//    @Override
//    public boolean login(String userId, String password)
//            throws DataAccessException {
//        User forLogin = new User();
//        forLogin.setUserId(userId);
//        forLogin.setUserId(password);
//        return userMapper.queryUser(forLogin).size() == 1;
//    }

    @Override
    public boolean login(User userForLogin) {
        return userMapper.queryUser(userForLogin).size() == 1;
    }

    @Override
    public User getUser(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        List<User> matchedUser = userMapper.queryUser(user);
        if (matchedUser.size() == 1) {
            return matchedUser.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserInfo(String userId) {
        User forQuery = new User();
        forQuery.setUserId(userId);
        List<User> users = userMapper.queryUser(forQuery);
        if (users.size() >= 1) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
