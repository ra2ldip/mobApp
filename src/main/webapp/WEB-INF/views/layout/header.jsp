<%-- 
    Document   : header
     Created on : 09 Jul, 2015, 3:55:37 PM
    Author     : Ratul
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
<!--        <link href="/css/navigation_oss.css" rel='stylesheet' type='text/css' />-->
        <title>NLC Ltd.</title>
        <style type="text/css">
            #menu{
                background: url('/images/menu.png') #ffa300;background-repeat: no-repeat;background-size: 20px 20px;background-position: center;
            }
            #menu:hover{
                background: url('/images/menu.png') #00bffe;background-repeat: no-repeat;background-size: 20px 20px;background-position: center;
            }
        </style>
        <script type="text/javascript">
            $(function() {
//                alert("OK")

                $('#profile').mouseout(function() {
                    $('#profile').hide()
                })

            })
            function openPro() {
                $('#profile').toggle()
            }
            function ch() {
                $('#l1').hide();
                $('#l2').show();
            }
            function ch1() {
                $('#l2').hide();
                $('#l1').show();
            }
        </script>
    </head>
    <body style="margin: 0px;">

        <!--<input type="checkbox" id="nav-trigger" class="nav-trigger" /><label for="nav-trigger"></label>-->
        <div class="headertop" style="text-align: left !important">
            <img src="/images/nlc_logo.png" alt="NLC Logo" width="34" height="32" class="nlclogo">
            Neyveli Lignite Corporation
            <div class="headertopdiv">
                   ( 'Navratna' - A Government of India Enterprise )
            </div>
           
        </div>
     
        
        <!--    
        <div style="position: static">        
            <div style="float: right;">
            <span  >   ${ _oss_mob_.user_name}  </span>
            <img src="http://172.16.24.43/idcardphotos/${fn:trim( _oss_mob_.user_id)}.jpg" width="25" height="33" style="border-radius: 4px;" > 
            </div>                    
        </div>
        -->


</body>
</html>
