package com.neuedu.project.service;

import com.neuedu.project.dao.UserMapper;
import com.neuedu.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerStudent(String studentId,
                                String password, String name) {

        User user = new User(studentId, password, name, 0);

        userMapper.addUser(user);
    }
}
