<%-- 
    Document   : home
    Created on : 8 Jul, 2015, 10:26:57 AM
    Author     : ratul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
        

       
    </head>
    <body >
        <br>
    ${all}
            <table style="width: 90%;font-family: sans-serif">
                <caption style="color: navy">Welcome ${user.user_name} to OSS Mobile Application </caption>
                <tr>
                    <td>
                    </td>
                </tr>
            </table>
                </div>
    </body>
</html>
