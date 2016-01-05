<%-- 
    Document   : userRegisTration
    Created on : 14 Jul, 2015, 3:27:25 PM
    Author     : Ratul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
        <title>NLC India</title>
    </head>
    <body >
        <t:headerOSSTag  afterLogin="false"/>      





        <div class="section">
            <div class="container">

                <div class="secbg">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-primary">
                            <div class="panel-heading-top">
                                <h1 id="SitePH_headID">OSS Login</h1>
                            </div>
                            <div class="panel-body sign-in">
                                <div id="SitePH_upd_progress1" style="display:none;" role="status" aria-hidden="true">

                                    <div class="loader">
                                        <img src="../../Images/galleryImages/loader.gif" alt="Preloader"></div>

                                </div>
                                <div id="SitePH_upd_pnl1">

                                    <div >

                                  


                                        <c:choose>
                                            <c:when test="${!finalPage}">
                                                <sf:form commandName="user">


                                                    <div>
                                                        <div class="form-group">

                                                            <label class="control-label">
                                                                <span class="control-label">Enter CPF No</span> </label>
                                                            <input type="text"  class="form-control" id="userId" name="userId" placeholder="CPF No">
                                                            <label class="control-label">
                                                                <span class="control-label">Password</span> </label>
                                                            <input type="text" name="mobileNo" id="mobileNo"  class="form-control" onfocus="this.value = '';" maxlength="10" placeholder="Mobile No (Eg: 98765 xxxxx)">

                                                        </div>
                                                        <div class="form-group">
                                                            <!--<input type="submit" name="ctl00$SitePH$btnuidotp" value="Submit" onclick="return validateUID();" id="SitePH_btnuidotp" class="btn cd-popup-trigger aadhaarbu">-->  
                                                            <input type="submit" value="Get OTP" class="button button-pill button-primary">
                                                        </div>                                
                                                    </div>
                                                </sf:form>
                                            </c:when>
                                            <c:when test="${finalPage}">
                                                <c:choose>
                                                    <c:when test="${isDone}">
                                                        <div align="center" style="color: green;font-weight: bold">
                                                            You have been registered to <a href="/oss/mobile/login.htm" >log in</a> now.
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${otpExpired}">
                                                        <div align="center" style="color: green;font-weight: bold">
                                                            You have reached maximum tries. <a href="/oss/mobile/login.htm" >Regenerate</a> OTP.
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <sf:form commandName="userOTP" >
                                                            <div>
                                                                <div class="form-group">

                                                                    <label class="control-label">
                                                                        <span class="control-label">Enter CPF No</span> </label>
                                                                    <input type="text"  class="form-control" readonly="" id="userId" name="userId" value="${userId}">
                                                                    <label class="control-label">
                                                                        <span class="control-label">Password</span> </label>
                                                                    <input type="text" name="mobileNo" readonly="" id="mobileNo" class="form-control" value="${mobileNo}">
                                                                    <label class="control-label">
                                                                        <span class="control-label">OTP</span> </label>
                                                                    <input  class="form-control"name="uOtp"  id="uOtp" value="" placeholder="OTP">
                                                                </div>
                                                                <div class="form-group">
                                                                    <!--<input type="submit" name="ctl00$SitePH$btnuidotp" value="Submit" onclick="return validateUID();" id="SitePH_btnuidotp" class="btn cd-popup-trigger aadhaarbu">-->  
                                                                    <input type="submit" value="Validate" class="button button-pill button-primary">
                                                                </div>                                
                                                            </div>
                                                        </sf:form>
                                                    </c:otherwise>
                                                </c:choose>

                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>

            </div></div>

    </div>                    
</div>
</body>
</html>
