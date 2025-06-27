package com.example.hackathonbe.global.config.annotation;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequireLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod handlerMethod) {
            RequireLogin requireLogin = handlerMethod.getMethodAnnotation(RequireLogin.class);

            if (requireLogin != null) {
                if (request.getHeader("userId") == null) {
                    throw new BusinessException(ErrorCode.AUTH_REQUIRED);
                }
            }
        }

        return true;
    }
}
