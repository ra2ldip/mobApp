<%-- 
    Document   : layout
    Created on : 09 Jul, 2015, 3:55:37 PM
    Author     : Ratul
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
<!--        <link href="/css/navigation_oss.css" rel='stylesheet' type='text/css' />-->
    </head>
    <body class="ui-mobile-viewport ui-overlay-a">

        <!--<center>-->
            <div class="ossMob">


                <!--<div id="signup" style="background: #dfe3ee;border: 1px #96A6C5 solid; width: 50%" >-->
                <table  id="layoutTab" width="100%"    cellspacing="0" cellpadding="0">
                    <!--_BEGIN_OF_TILES_BLOCK_-->

                    <%
                        if (!request.getParameterMap().containsKey("__popUp__")) {
                    %>

                    <tr>
                        <td colspan="1">
                            <tiles:insertAttribute name="header" />
                        </td>
                    </tr>
                    <%}%>
                    <!--_END_OF_TILES_BLOCK_-->
                    <tr valign="top">
                        <!--_BEGIN_OF_TILES_BLOCK_-->
                        <!--                <td height="" width="222px" >
                        <%--<tiles:insertAttribute name="menu" />--%>
                        <%--<tiles:insertAttribute name="menu_side" />--%>
                    </td>-->
                        <!--_END_OF_TILES_BLOCK_-->
                       
                        <td valign="top"  align="center" >
                            <t:menuItems afterLogin="true"/>

                                <div class="site-wrap">  
                            <div  class="bodyDiv"> 
                                
                                                         <tiles:insertAttribute name="body" />
                                </div>

                            </div>
                        </td>
                    </tr>
                    <%
                        if (!request.getParameterMap().containsKey("__popUp__")) {
                    %>
                    <tr>
                        <td colspan="1" align="center" style="vertical-align: middle;">
                            <!--
                            <div  style="background-color: #DFE3EE;width: 100%;text-align: center;margin: 0px;padding: 0px;padding-top: 1px;padding-bottom: 1px;"> 
                                <%--<tiles:insertAttribute name="footer" /> --%>
                            </div>
                            -->
                        </td>
                    </tr>
                    <%}%>
                </table>
            </div>
            <!--</div>-->
        <!--</center>-->

    </body>
</html>