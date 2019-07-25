package com.neuedu.project.dao;

import com.neuedu.project.domain.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    void addTest(Test test);


}
