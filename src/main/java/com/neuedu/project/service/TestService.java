package com.neuedu.project.service;

import com.neuedu.project.domain.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {

    void autoCreateTest(int courseId, int cqCount, int sqConut);

    List<Test> getArrangedTestsByCourseId();

}
