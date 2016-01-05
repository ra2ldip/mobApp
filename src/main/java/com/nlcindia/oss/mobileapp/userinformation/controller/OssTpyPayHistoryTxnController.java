/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.userinformation.controller;

import com.nlcindia.oss.mobileapp.userinformation.OssTpyPayHistoryTxn;
import com.nlcindia.oss.mobileapp.userinformation.service.OssTpyPayHistoryTxnService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
public class OssTpyPayHistoryTxnController {

    @Autowired
    OssTpyPayHistoryTxnService otphtService;

    @RequestMapping(value = "/oss/mobile/pay.htm", method = RequestMethod.GET)
    public String getPayDetails(Model model, OssAppUser oau) {
        float basicPay=0; 
        float grossPay=0;
        float netPay = 0;
        float totalDeduction =0;
        float roundingOff = 0;
//        if (yyyy==null || dd==null) {
//            model.addAttribute("noDate", "Please Select Month and Year");
//        } else {
            List<OssTpyPayHistoryTxn> lstPayTxn = otphtService.getLstAllTPayHist(oau.getUser_id(), 2015,6);
            
            for (OssTpyPayHistoryTxn ossTpyPayHistoryTxn : lstPayTxn) {
                  if(ossTpyPayHistoryTxn.getERNG_CODE() == OssTpyPayHistoryTxn.BASIC_ERNG_CODE) {
                      basicPay = ossTpyPayHistoryTxn.getPAID_AMT();
                  }else if(ossTpyPayHistoryTxn.getERNG_CODE() < OssTpyPayHistoryTxn.GROSS_PAY_ERNG_CODE_LIMIT ) {
                      if(ossTpyPayHistoryTxn.getERNG_CODE() == OssTpyPayHistoryTxn.ROUNDING_ERNG_CODE)
                          roundingOff = ossTpyPayHistoryTxn.getPAID_AMT();
                      else 
                         grossPay = grossPay + ossTpyPayHistoryTxn.getPAID_AMT();                      
                  }else if(ossTpyPayHistoryTxn.getERNG_CODE()>OssTpyPayHistoryTxn.GROSS_PAY_ERNG_CODE_LIMIT) {
                      if(ossTpyPayHistoryTxn.getERNG_CODE() ==OssTpyPayHistoryTxn.NET_PAY_ERNG_CODE)
                          netPay = ossTpyPayHistoryTxn.getPAID_AMT();
                      else
                        totalDeduction = totalDeduction + ossTpyPayHistoryTxn.getPAID_AMT();
                  }                   
           }
           grossPay = grossPay + basicPay +roundingOff;
           
            model.addAttribute("basicPay",basicPay);
            model.addAttribute("grossPay",grossPay);
            model.addAttribute("netPay",netPay);
            
            model.addAttribute("totalDeduction",totalDeduction);
            //model.addAttribute("lstPayTxn",  lstPayTxn);
//        }
        return "oss/payDetails";
    }
}
