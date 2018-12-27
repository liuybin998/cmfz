package com.baizhi.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Object attribute = req.getSession().getAttribute("login");
        if(attribute!=null){
            chain.doFilter(req, response);
        }else{
            res.sendRedirect("/cmfz_lyb/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
