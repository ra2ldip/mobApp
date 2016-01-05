/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nlcindia.oss.mobileapp.userinformation.controller;

import com.nlcindia.oss.mobileapp.userinformation.dao.CamsTdayRepo;
import com.nlcindia.oss.mobileapp.userinformation.service.OssTpyPayHistoryTxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller

public class CamsTdayController {
@Autowired CamsTdayRepo tdayRepo;

@RequestMapping(value = "/oss/mobile/attendance.htm",method = RequestMethod.GET)
public String getAttendance(Model m,OssAppUser appUser) {
// list CamsTday   
//    tdayRepo.fi
    return null;
}
}
