/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nlcindia.oss.mobileapp.config;


import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author ratul
 */
public class Initializer implements WebApplicationInitializer{

    
       @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(AppConfig.class);

        ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", new DispatcherServlet(mvcContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        EnumSet<DispatcherType> e = EnumSet.of(DispatcherType.REQUEST);
        sc.addFilter("securityFilter", new SecurityFilterOSS(mvcContext)).addMappingForServletNames(e, true, "dispatcher");
        //sc.addListener(ContextLoaderListener.class);
    }
    
}
