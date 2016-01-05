package com.nlcindia.oss.mobileapp.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ratulSarkar
 */
@Controller
public class AllURLResoverController {
    @RequestMapping(value = "/oss/mobile/tasks",method = RequestMethod.GET)
    public String allUrlResolver(){
        return "admin/allUrl";
    }
}
