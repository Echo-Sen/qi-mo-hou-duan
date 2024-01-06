package com.olrando.filter;

import com.alibaba.fastjson.JSONObject;
import com.olrando.pojo.Result;
import com.olrando.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://front.olrando.cn");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 预检请求直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return;
        }

        String url = request.getRequestURI().toString();
        log.info("请求路径：{}", url); // 请求路径

        // 登录请求放行
        if (url.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌：{}", token);

        // 令牌不存在或解析失败
        if (!StringUtils.hasLength(token) || !isValidToken(token)) {
            log.info("Token不存在或令牌解析失败");
            Result responseResult = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        // 正常请求放行
        filterChain.doFilter(request, response);
    }

    private boolean isValidToken(String token) {
        try {
            JwtUtils.parseJwt(token);
            return true;
        } catch (Exception e) {
            log.info("令牌解析失败!");
            return false;
        }
    }
}
