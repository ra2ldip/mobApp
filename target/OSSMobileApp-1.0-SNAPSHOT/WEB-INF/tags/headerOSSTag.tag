<%-- 
    Document   : headerOSSTag
    Created on : 18 Jul, 2015, 2:58:58 PM
    Author     : ratul
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="afterLogin" required="true" type="java.lang.Boolean"%>


<%-- any content can be specified here e.g.: --%>
<div class="headertop" style="text-align: left !important">
    <img src="/images/nlc_logo.png" alt="NLC Logo" width="34" height="32" class="nlclogo">
    Neyveli Lignite Corporation
    <div class="headertopdiv">
        ( 'Navratna' - A Government of India Enterprise )
    </div>
    
</div>
<t:menuItems afterLogin="false"/>
<div class="site-wrap">  
                <div  class="bodyDiv">
<div class="header">
    <!--<div class="container">-->                
    <!--<div class="emblem">-->                    
    <img src="/images/oss_logo.png" id="oss_logo" alt="OSS Logo" class="mahalogo" style="float: left;">
    <!--class="mahalogo"-->
    <!--</div>-->
    <div class="cname">
        <span id="HeaderMain1_lbl_headername" class="headername"><div class="digital">Online Service System</div></span>                     
        <div class="tagline">
            Computer Services <br> Corporate Office 
        </div>
    </div>                
    <!--</div>-->
</div>

