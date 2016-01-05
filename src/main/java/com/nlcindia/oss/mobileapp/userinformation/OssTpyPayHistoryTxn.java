package com.nlcindia.oss.mobileapp.userinformation;

import java.math.BigDecimal;

/**
 *
 * @author Administrator
 */
//@Entity
public class OssTpyPayHistoryTxn {

    public static final int BASIC_ERNG_CODE = 1;
    public static final int ROUNDING_ERNG_CODE = 444;
    public static final int GROSS_PAY_ERNG_CODE_LIMIT = 500;
    public static final int NET_PAY_ERNG_CODE = 888;

    private long CPF_NO;
    private int ERNG_CODE;
    private int PAID_YEAR;
    private int PAID_MONTH;
    private float ACTUAL_AMT;
    private float PAID_AMT;
    private float ARREAR_AMT;

    public OssTpyPayHistoryTxn() {
    }

    public OssTpyPayHistoryTxn(long CPF_NO, int ERNG_CODE, int PAID_YEAR, int PAID_MONTH, float ACTUAL_AMT, float PAID_AMT, float ARREAR_AMT) {
        this.CPF_NO = CPF_NO;
        this.ERNG_CODE = ERNG_CODE;
        this.PAID_YEAR = PAID_YEAR;
        this.PAID_MONTH = PAID_MONTH;
        this.ACTUAL_AMT = ACTUAL_AMT;
        this.PAID_AMT = PAID_AMT;
        this.ARREAR_AMT = ARREAR_AMT;
    }

    public long getCPF_NO() {
        return CPF_NO;
    }

    public void setCPF_NO(long CPF_NO) {
        this.CPF_NO = CPF_NO;
    }

    public int getERNG_CODE() {
        return ERNG_CODE;
    }

    public void setERNG_CODE(int ERNG_CODE) {
        this.ERNG_CODE = ERNG_CODE;
    }

    public int getPAID_YEAR() {
        return PAID_YEAR;
    }

    public void setPAID_YEAR(int PAID_YEAR) {
        this.PAID_YEAR = PAID_YEAR;
    }

    public int getPAID_MONTH() {
        return PAID_MONTH;
    }

    public void setPAID_MONTH(int PAID_MONTH) {
        this.PAID_MONTH = PAID_MONTH;
    }

    public float getACTUAL_AMT() {
        return ACTUAL_AMT;
    }

    public void setACTUAL_AMT(float ACTUAL_AMT) {
        this.ACTUAL_AMT = ACTUAL_AMT;
    }

    public float getPAID_AMT() {
        return PAID_AMT;
    }

    public void setPAID_AMT(float PAID_AMT) {
        this.PAID_AMT = PAID_AMT;
    }

    public float getARREAR_AMT() {
        return ARREAR_AMT;
    }

    public void setARREAR_AMT(float ARREAR_AMT) {
        this.ARREAR_AMT = ARREAR_AMT;
    }

}
