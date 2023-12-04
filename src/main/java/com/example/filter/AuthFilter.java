package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/*"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        HttpServletRequest httpSession = (HttpServletRequest) request;
        HttpSession session = httpSession.getSession();

        if (session.getAttribute("user") == null) {
            ((HttpServletResponse) response).sendRedirect("/login.jsp");
        }
    }
}