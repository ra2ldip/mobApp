package com.nlcindia.oss.mobileapp.userinformation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ratul
 */
@Controller
public class UserHomePageController {

   

    @RequestMapping(value = "/oss/mobile/home.htm", method = RequestMethod.GET)
    public String getHomepageForUser(Model model, OssAppUser omu) {
        model.addAttribute("user", omu);
        return "oss/home";
    }
}
