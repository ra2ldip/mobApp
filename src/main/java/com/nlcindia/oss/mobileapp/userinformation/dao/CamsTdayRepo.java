/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nlcindia.oss.mobileapp.userinformation.dao;

import com.nlcindia.oss.mobileapp.userinformation.CamsTday;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Administrator
 */
public interface  CamsTdayRepo  extends JpaRepository<CamsTday, Long>{
    @Query("select c from CamsTday c where c.CPF_NO=?")
    List <CamsTday> findByCPFNO(long cpf_no);
    
    
}
