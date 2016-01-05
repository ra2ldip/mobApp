package com.nlcindia.oss.mobileapp.userinformation.dao;

import com.nlcindia.oss.mobileapp.userinformation.OssMobUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */
public interface OssMobUserRepo extends JpaRepository<OssMobUser, Long> {

    OssMobUser findByUserid(String userid);

}
