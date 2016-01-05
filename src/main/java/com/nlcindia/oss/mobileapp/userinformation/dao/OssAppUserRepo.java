package com.nlcindia.oss.mobileapp.userinformation.dao;

import com.nlcindia.oss.mobileapp.userinformation.controller.OssAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author muthu vairavan
 */
public interface OssAppUserRepo extends JpaRepository<OssAppUser, Long> {

    @Query(value = "select Cryptit.Encrypt(?)|| Cryptit.Encrypt(?)from DUAL", nativeQuery = true)
    public String getLoginDetails(String passwd, long userId);

    @Query(value = "SELECT CASE WHEN (SELECT 'X' FROM OSS_USER_APPS_ALLOTED WHERE APP_ID='MOB'"
            + " and USER_ID=?) IS NULL THEN 'NO' ELSE 'YES' END dual"
            + "  FROM dual", nativeQuery = true)
    String isMobAuthienticatedUser(long userId);

    @Query(value = "SELECT CASE WHEN (SELECT 'X' FROM INT_USER_MAS "
            + "WHERE USERNAME=?1 and MOBILE_NO=?2)"
            + " IS NULL THEN 'NO' ELSE 'YES' END dual FROM dual", nativeQuery = true)
    String isMobileEnabledUser(long userId, long mobileNo);

    @Transactional
    @Modifying
    @Query(value = "update OSS_USER_APPS_ALLOTED set APP_ID='MOB' where USER_ID=?", nativeQuery = true)
    void upadateUserAllottedAsMOB(long userId);
}
