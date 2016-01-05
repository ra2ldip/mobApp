<%-- 
    Document   : menuItems
    Created on : 18 Jul, 2015, 3:25:27 PM
    Author     : Administrator
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="afterLogin" required="true" type="java.lang.Boolean"%>

<%-- any content can be specified here e.g.: --%>
<c:choose>
    <c:when test="${afterLogin}">
        <input type="checkbox" id="nav-trigger" class="nav-trigger" />
        <label for="nav-trigger" ></label>
        <!--</div>-->
        <div class="navigation" >
            <li class="nav-item"><a href="/oss/mobile/home.htm">Home</a></li>
            <li class="nav-item"><a href="/oss/users/list">All User</a></li>
            <li class="nav-item"><a href="/oss/mobile/pay.htm">Pay</a></li>
            <li class="nav-item"><a href="#">Attendance</a></li>
            <li class="nav-item"><a href="#">Power Gen.</a></li>
            <li class="nav-item"><a href="/logoff.htm">Log Out</a></li>
        </div>

    </c:when>
        <c:when test="${!afterLogin}">
        <input type="checkbox" id="nav-trigger" class="nav-trigger" />
        <label for="nav-trigger" ></label>
        <!--</div>-->
        <div class="navigation" >
            <li class="nav-item"><a href="/start/oss/mobile/start.htm">Start</a></li>
            <li class="nav-item"><a href="#">About</a></li>
            <li class="nav-item"><a href="/oss/mobile/login.htm">Log in</a></li>
            <li class="nav-item"><a href="/registration/oss/mobile/appRegistration.htm">Register</a></li>
            <!--<li class="nav-item"><a href="#">About</a></li>-->
<!--            <li class="nav-item"><a href="/oss/mobile/pay.htm">Pay</a></li>
            <li class="nav-item"><a href="#">Attendance</a></li>
            <li class="nav-item"><a href="#">Power Gen.</a></li>
            <li class="nav-item"><a href="/logoff.htm">Log Out</a></li>-->
        </div>

    </c:when>
        
</c:choose>
