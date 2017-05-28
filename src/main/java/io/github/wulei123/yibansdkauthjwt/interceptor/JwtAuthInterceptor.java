package io.github.wulei123.yibansdkauthjwt.interceptor;


import io.github.wulei123.yibansdkauthjwt.annotations.YiBanJwtAuth;
import io.github.wulei123.yibansdkauthjwt.config.JwtMessageConfig;
import io.github.wulei123.yibansdkauthjwt.utils.jwt.JwtHandler;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by 武雷 on 2017/5/27.
 */
@Component
public class JwtAuthInterceptor implements HandlerInterceptor{

    @Autowired
    private JwtMessageConfig jwtMessageConfig;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        Claims userInfo = JwtHandler.jwtParser(httpServletRequest.getHeader("YiBan-JWT"),jwtMessageConfig.getSecret()).getBody();
        if(!method.isAnnotationPresent(YiBanJwtAuth.class)) {
            return true;
        }else if(method.isAnnotationPresent(YiBanJwtAuth.class)
                && (Boolean)userInfo.get("islogin")
                && System.currentTimeMillis()>=((Long)userInfo.get("expiration"))){
            return true;
        }else if(method.isAnnotationPresent(YiBanJwtAuth.class)
                && (Boolean)userInfo.get("islogin")
                && System.currentTimeMillis()<((Long)userInfo.get("expiration"))){
            httpServletResponse.sendError(2,"your token is out of date");
            return false;
        }else{
            httpServletResponse.sendError(1,"you are not login");
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }

}