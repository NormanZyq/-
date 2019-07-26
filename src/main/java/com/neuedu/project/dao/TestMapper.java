package com.neuedu.project.dao;

import com.neuedu.project.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    void addTest(Test test);

    List<Test> getStudentTests(String studentId);


}
