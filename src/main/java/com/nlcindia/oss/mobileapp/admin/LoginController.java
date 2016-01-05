package com.nlcindia.oss.mobileapp.admin;

import com.nlcindia.oss.mobileapp.userinformation.OssMobUser;
import com.nlcindia.oss.mobileapp.userinformation.controller.OssAppUser;
import com.nlcindia.oss.mobileapp.userinformation.dao.OssAppUserRepo;
import com.nlcindia.oss.mobileapp.userinformation.dao.OssMobUserRepo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ratul
 */
@Controller
public class LoginController {

    @Autowired
    OssMobUserRepo ossMobUserRepo;
    @Autowired
    OssAppUserRepo appUserRepo;
    

    @RequestMapping(value = "/start/oss/mobile/start.htm", method = RequestMethod.GET)
    public String indexPage() {
//        m.addAttribute("user", this);
        return "oss/start";
    }
        
    @RequestMapping(value = "/oss/mobile/login.htm", method = RequestMethod.GET)
    public String logInPage(Model m) {
        m.addAttribute("user", this);
        return "admin/loginPage";
    }

    @RequestMapping(value = "/oss/mobile/login.htm", method = RequestMethod.POST)
    public String submitLoginPage( @RequestParam("userId") long userId, @RequestParam("passwd") String pass,Model m, HttpSession session, HttpServletRequest req) {

            OssAppUser obj = appUserRepo.findOne(userId);
            if (obj == null || !obj.getPasswd().equals(appUserRepo.getLoginDetails(pass,userId))) {
                m.addAttribute("err", "Invalid Username or Password");
                return "admin/loginPage";
            }
            if(appUserRepo.isMobAuthienticatedUser(obj.getUser_id()).equals("NO")){
                m.addAttribute("err", "You are not authorized.");
                return "admin/loginPage";
            }
            session.invalidate();
            session = req.getSession(true);
            session.setAttribute("_oss_mob_", obj);
   


        return "redirect:/oss/mobile/home.htm";
    }

    @RequestMapping(value = "/logoff.htm")
    public String logoff(HttpSession session, OssMobUser uo) {
        session.invalidate();
        return "redirect:/oss/mobile/login.htm";
    }
}
