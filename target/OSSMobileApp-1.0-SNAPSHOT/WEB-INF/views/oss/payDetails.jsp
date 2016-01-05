<%-- 
    Document   : payDetails
    Created on : 10 Jul, 2015, 7:40:33 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/css/m_oss.css" rel='stylesheet' type='text/css' />
        <title>JSP Page</title>
    </head>
    <body>
        <!--<h1>Hello World!</h1>-->
        <div style="height: auto ;overflow: scroll;overflow-x: hidden">
            <table class="osstable-tdgrid">
                <tr><th>Basic Pay</th><td  style="text-align: right"><fmt:formatNumber  value="${basicPay}" maxFractionDigits="2" minFractionDigits="2" /></td></tr>
                <tr><th>Gross Pay</th><td style="text-align: right"><fmt:formatNumber  value="${grossPay}" maxFractionDigits="2" minFractionDigits="2"/></td></tr>
                <tr><th>Total Deduction</th><td style="text-align: right"><fmt:formatNumber  value="${totalDeduction}" maxFractionDigits="2" minFractionDigits="2"/></td></tr>
                <tr><th>Net Pay</th><td style="text-align: right"><fmt:formatNumber  value="${netPay}" maxFractionDigits="2" minFractionDigits="2"/></td></tr>
            </table>
        </div>
    </body>
</html>
