package com.si.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
       // set encoding to utf-8
       req.setCharacterEncoding("UTF-8");
       res.setCharacterEncoding("UTF-8");
       System.out.println("hihi");
       chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
       /* empty */
    }

    @Override
   public void destroy() {
       /* empty */
   }
  }