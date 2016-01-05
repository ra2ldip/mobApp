/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.userinformation.controller;

import com.nlcindia.oss.mobileapp.userinformation.OssMobUser;
import com.nlcindia.oss.mobileapp.userinformation.dao.OssAppUserRepo;
import com.nlcindia.oss.mobileapp.userinformation.dao.OssMobUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Administrator
 */
@Controller
@SessionAttributes(value = "user")
public class OssMobUserController {

    @Autowired
    OssMobUserRepo omur;
    @Autowired
    OssAppUserRepo oaur;

    @RequestMapping(value = "/oss/mobileusers.htm", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("rs", "Ratul Sarkar");
        return "oss/allUsers";
    }

    @RequestMapping(value = "/oss/users/list", method = RequestMethod.GET)
    public String getAllUsers(Model model, OssAppUser omu) {
        model.addAttribute("allUsers", oaur.findAll());
       
        return "oss/userManagement";
    }
}
