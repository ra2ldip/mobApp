/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.userinformation;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.apache.commons.lang.builder.ToStringBuilder;

/**@Entity
@Table(name = "OSS_APP_USERS")
 *
 * @author Administrator
 */
@Entity
public class OssMobUser implements Serializable {
public static final int ADMIN=1;
public static final int ACTIVE_USER=1;
public static final int RETIRED_USER=1;
public static final int GUEST_USER=1;
    @Id
    private long id;
    @Column(length = 40)
    private String userid;
    private String userName;
    @Column(length = 50)
    private String passwd;
    private long createdUserId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdTimeStamp;
    private int userType;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the createdUserId
     */
    public long getCreatedUserId() {
        return createdUserId;
    }

    /**
     * @param createdUserId the createdUserId to set
     */
    public void setCreatedUserId(long createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
     * @return the createdTimeStamp
     */
    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    /**
     * @param createdTimeStamp the createdTimeStamp to set
     */
    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    /**
     * @return the userType
     */
    public int getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

}
