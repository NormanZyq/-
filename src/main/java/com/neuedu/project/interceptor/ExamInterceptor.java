package com.neuedu.project.interceptor;

import com.neuedu.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 负责控制学生是否有参加某一场考试的权限。
 *
 * 控制包括：如果学生不在参加考试列表，则不允许考试
 * 如果考试时间已结束，不允许参加考试
 *
 */
public class ExamInterceptor implements HandlerInterceptor {

    @Autowired
    private TestService testService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // todo
        return true;
    }
}
