/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Administrator
 */
public class SecurityFilterOSS implements Filter {

    ApplicationContext ac;

    public SecurityFilterOSS() {
    }

    public SecurityFilterOSS(ApplicationContext ac) {
        this.ac = ac;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest breq = (HttpServletRequest) request;
        HttpServletResponse bresp = (HttpServletResponse) response;
        String url = breq.getRequestURI();

        if (url.startsWith("/start/")||url.startsWith("/css/") || url.startsWith("/images/") || url.startsWith("/scripts/") || url.startsWith("/applets/") || url.startsWith("/registration/") ) {
            // check if already logged in
        } 
        else if ("/oss/mobile/login.htm".equals(url)) {
            if (breq.getSession().getAttribute("_oss_mob_") != null) {
                System.out.println("I Am Printed Here");
                bresp.sendRedirect("/oss/mobile/home.htm");
            }
        } else {
            System.out.println("I am :"+breq.getSession().getAttribute("_oss_mob_"));
            if (breq.getSession().getAttribute("_oss_mob_")== null) {
                bresp.sendRedirect("/oss/mobile/login.htm");
                return;
            }
        }
        //chain
        chain.doFilter(breq, bresp);
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
