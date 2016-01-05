/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.userinformation.service;

import com.nlcindia.oss.mobileapp.userinformation.OssTpyPayHistoryTxn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class OssTpyPayHistoryTxnService {

    @Autowired
    JdbcTemplate jt;

    public List getLstAllTPayHist(long cpfNo, int yyyy, int mm) {
        String sql = "select * from TPY_PAY_HISTORY_TXN@mines WHERE CPF_NO=" + cpfNo + "and paid_year=" + yyyy + " and paid_month=" + mm;
//        jt.qu
        List<OssTpyPayHistoryTxn> otphts = new ArrayList<>();
        List<Map<String, Object>> ms = jt.queryForList(sql);
        for (Map<String, Object> map : ms) {
            OssTpyPayHistoryTxn txn = new OssTpyPayHistoryTxn(Long.parseLong(map.get("CPF_NO").toString()),
                    Integer.parseInt(map.get("ERNG_CODE").toString()), Integer.parseInt(map.get("PAID_YEAR").toString()), Integer.parseInt(map.get("PAID_MONTH").toString()),
                    Float.parseFloat(map.get("ACTUAL_AMT").toString()),
                    Float.parseFloat(map.get("PAID_AMT").toString()), Float.parseFloat(map.get("ARREAR_AMT").toString()));
            otphts.add(txn);
        }
        return otphts;
    }
}
