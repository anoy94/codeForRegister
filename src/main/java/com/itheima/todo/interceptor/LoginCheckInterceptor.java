package com.itheima.todo.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.todo.pojo.Results;
import com.itheima.todo.pojo.TokenCheck;
import com.itheima.todo.service.JwtService;
import com.itheima.todo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtService jwtService;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }

        String jwt= request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头为空，返回未登录信息");
            Results error=Results.error("NOT_LOGIN");
            String notlogin= objectMapper.writeValueAsString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败");
            Results error=Results.error("NOT_LOGIN");
            String notlogin= objectMapper.writeValueAsString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        TokenCheck tok = new TokenCheck();
        tok.setAccount(JwtUtils.parseJWT(jwt).get("account", String.class));
        if(jwtService.tokensel(tok)==1){
            log.info("令牌合法");
            return true;}
        log.info("令牌错误");
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
