/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nlcindia.oss.mobileapp.userinformation;

import com.sun.javafx.beans.IDProperty;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "oss_m_emp_attendance")
public class CamsTday {
    @Id
    private long CPF_NO;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ATTENDANCE_DATE;
    private String SHIFT;
    private String IN_TIME;
    private String OUT_TIME;
    private String status;

    public long getCPF_NO() {
        return CPF_NO;
    }

    public void setCPF_NO(long CPF_NO) {
        this.CPF_NO = CPF_NO;
    }

    public Date getATTENDANCE_DATE() {
        return ATTENDANCE_DATE;
    }

    public void setATTENDANCE_DATE(Date ATTENDANCE_DATE) {
        this.ATTENDANCE_DATE = ATTENDANCE_DATE;
    }

    public String getSHIFT() {
        return SHIFT;
    }

    public void setSHIFT(String SHIFT) {
        this.SHIFT = SHIFT;
    }

    public String getIN_TIME() {
        return IN_TIME;
    }

    public void setIN_TIME(String IN_TIME) {
        this.IN_TIME = IN_TIME;
    }

    public String getOUT_TIME() {
        return OUT_TIME;
    }

    public void setOUT_TIME(String OUT_TIME) {
        this.OUT_TIME = OUT_TIME;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
