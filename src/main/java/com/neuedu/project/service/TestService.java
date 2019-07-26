package com.neuedu.project.service;

import com.neuedu.project.domain.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    void autoCreateTest(int courseId, int cqCount, int sqCount, String currentTime,int duration);

    List<Test> getArrangedTestsByCourseId();

//    int Calcualte_OJLD(int i, int j);

}
