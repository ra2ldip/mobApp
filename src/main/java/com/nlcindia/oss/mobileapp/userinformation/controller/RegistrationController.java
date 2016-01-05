package com.nlcindia.oss.mobileapp.userinformation.controller;

import com.nlcindia.oss.mobileapp.userinformation.dao.OssAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ratul
 */
@Controller
@SessionAttributes({"userId", "mobileNo", "otp"})
public class RegistrationController {

    @Autowired
    OssAppUserRepo oaur;

    @RequestMapping(value = "/registration/oss/mobile/appRegistration.htm", method = RequestMethod.GET)
    public String userRegistration(Model model) {
        model.addAttribute("user", this);
        model.addAttribute("finalPage", false);
        return "oss/userRegisTration";
    }

    @RequestMapping(value = "/registration/oss/mobile/appRegistration.htm", method = RequestMethod.POST)
    public String setOTPforRegistration(@RequestParam("userId") long userId, @RequestParam("mobileNo") long mobileNo, Model m) {
        if (oaur.isMobileEnabledUser(userId, mobileNo).equals("NO")) {
            m.addAttribute("err", "Your mobile no is not registered for OSS");
            m.addAttribute("finalPage", false);
            return "oss/userRegisTration";
        }
        m.addAttribute("userId", userId);
        m.addAttribute("mobileNo", mobileNo);
        return "redirect:/registration/oss/mobile/finalize/appRegistration.htm";
    }
    private int retryLogin = 0;
   private long otp = 0;

    @RequestMapping(value = "/registration/oss/mobile/finalize/appRegistration.htm", method = RequestMethod.GET)
    public String getOTPFromUser(Model m, @ModelAttribute("userId") long userId, @ModelAttribute("mobileNo") long mobileNo) {
        retryLogin++;
        if (retryLogin <= 3) {
            m.addAttribute("userId", userId);
            m.addAttribute("mobileNo", mobileNo);
            m.addAttribute("finalPage", true);
            m.addAttribute("userOTP", this);

//        long otp = (long) (m.asMap().get("otp")==null ? 0 : (long) m.asMap().get("otp"));
            if (otp > 0) {
                otp = 9187;
            }
            m.addAttribute("otp", otp);
        } else {
            m.addAttribute("otpExpired", true);
        }

        return "oss/userRegisTration";
    }

    @Transactional
    @RequestMapping(value = "/registration/oss/mobile/finalize/appRegistration.htm", method = RequestMethod.POST)
    public String validateOTPFromUser(Model m, @ModelAttribute("userId") long userId, @ModelAttribute("mobileNo") long mobileNo,
            @ModelAttribute("otp") long otp, @RequestParam("uOtp") long uOtp) {
        m.addAttribute("finalPage", true);
        if (uOtp != otp) {
            m.addAttribute("userId", userId);
            m.addAttribute("mobileNo", mobileNo);
            m.addAttribute("userOTP", this);
            m.addAttribute("err", "Put correct OTP");
            return "oss/userRegisTration";
        }
        oaur.upadateUserAllottedAsMOB(userId);
        m.addAttribute("isDone", true);
        return "oss/userRegisTration";
    }
}
