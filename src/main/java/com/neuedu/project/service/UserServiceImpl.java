package com.neuedu.project.service;


import com.neuedu.project.dao.UserMapper;
import com.neuedu.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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
        userMapper.addUser(newUser);
    }

    @Override
    public boolean login(String userId, String password)
            throws DataAccessException {
        User forLogin = new User();
        forLogin.setUserId(userId);
        forLogin.setUserId(password);
        return userMapper.queryUser(forLogin).size() == 1;
    }
}
