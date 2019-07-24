package com.neuedu.project.service;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    void registerStudent(String studentId, String password, String name);

}
