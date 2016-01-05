<%-- 
    Document   : loginPage
    Created on : 8 Jul, 2015, 10:07:22 AM
    Author     : ratul
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
        <!--<link href="/css/bootstrap.min.css" rel='stylesheet' type='text/css' />-->
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
        <link href="/css/m_button.css" rel='stylesheet' type='text/css' />
        <script src="scripts/m_oss.js"></script>

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

                                        <sf:form commandName="user">
                                            <div>
                                                <div class="form-group">

                                                    <label class="control-label">
                                                        <span class="control-label">Enter CPF No</span> </label>
                                                    <input name="userId" type="text" name="userId"  value="" maxlength="12" id="userId" placeholder="Enter CPF No" class="form-control">
                                                    <label class="control-label">
                                                        <span class="control-label">Password</span> </label>
                                                    <input name="passwd" type="password" value="" maxlength="12" id="passwd" placeholder="Enter Password" class="form-control">

                                                </div>
                                                <div class="form-group">
                                                    <input type="submit" name="ctl00$SitePH$btnuidotp" value="Submit" onclick="return validateUID();" id="SitePH_btnuidotp" class="btn cd-popup-trigger aadhaarbu">  
                                                    <!--<input type="submit" value="Go" class="button button-pill button-primary">-->
                                                </div>                                
                                            </div>
                                        </sf:form>
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