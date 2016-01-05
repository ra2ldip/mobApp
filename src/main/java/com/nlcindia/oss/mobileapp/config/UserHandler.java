/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.config;

import com.nlcindia.oss.mobileapp.userinformation.OssMobUser;
import com.nlcindia.oss.mobileapp.userinformation.controller.OssAppUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *
 * @author muthu vairavan
 */
public class UserHandler implements HandlerMethodArgumentResolver{

    @Override
    public boolean supportsParameter(MethodParameter mp) {
         return mp.getParameterType().equals(OssAppUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavc, NativeWebRequest nwr, WebDataBinderFactory wdbf) throws Exception {
         if (parameter.getParameterType().equals(OssAppUser.class)) {

            HttpSession session = ((HttpServletRequest) nwr.getNativeRequest()).getSession();
            return getUserObj(session);
        }
        return null;
    }
     public static OssAppUser getUserObj(HttpSession session) {
        if (session.getAttribute("_oss_mob_") == null) {
            throw new RuntimeException("user Object is null");
        }
        OssAppUser uo = (OssAppUser) session.getAttribute("_oss_mob_");
        return uo;
    }
}
