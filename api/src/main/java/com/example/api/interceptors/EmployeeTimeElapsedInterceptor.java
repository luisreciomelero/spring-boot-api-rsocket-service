package com.example.api.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("employee-te-interceptor")
public class EmployeeTimeElapsedInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeTimeElapsedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("EmployeeTimeElapsedInterceptor: >>> preHandler()");
        long initTime = System.currentTimeMillis();
        request.setAttribute("initTime", initTime);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("EmployeeTimeElapsedInterceptor: >>> postHandle()");
        long endTime = System.currentTimeMillis();
        long initTime = (Long) request.getAttribute("initTime");
        long timeElapsed = endTime - initTime;

        logger.info("Time Elapsed: " + timeElapsed + " ms");
        logger.info("EmployeeTimeElapsedInterceptor: postHandler >>>");
    }
/*
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    */
}
