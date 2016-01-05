<%-- 
    Document   : userManagement
    Created on : 8 Jul, 2015, 2:37:06 PM
    Author     : ratul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content ="width=device-width,initial-scale=1,user-scalable=yes" />
        <script type="text/javascript" src="/scripts/jquery.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui.js"></script>
        <script type="text/javascript" src="/scripts/jquery-ui-min.js"></script>
        <link rel="stylesheet" href="/css/jquery-ui.css" type="text/css">
        <title>JSP Page</title>
        <script type="text/javascript">
            function editUser(id) {
                alert(id)
            }
            function delUser(id) {
                alert(id)
                alert( )
            }
            function addUser() {
                $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 350,
                    width: 756,
                    modal: true,
                    buttons: {
                        "Save": function() {
                            ajaxCall();
                        },
                        Cancel: function() {
                            $(this).dialog("close");
                        },
                        "Reset": function() {
                            $('#rmks').val('');
                            $('#check').attr('checked', false);
                        }
                    },
                    close: function() {
                        $('#curRowId').val('');
                        $('#rmks').val('');
                        $('#check').attr('checked', false);
                    }
                });
                $("#dialog-form").dialog("open");
            }
        </script>
    </head>
    <body>
       

        <table style="width: 100%" >
            <caption>All OSS Users Information</caption>
            <br>
            <tr ><th style="background: gainsboro">User Name</th><th style="background: gainsboro;float: right">User Id</th>

            </tr>
            <tr><td colspan="2">
                        <table style="width: 100%" class="osstable-tdgrid">
                            <c:forEach items="${allUsers}" var="user">
                                <tr><td style="background: #f0f0f0">${user.user_name}</td>
                                    <td style="background: #f0f0f0">${user.user_id}</td>
                                    <%--<c:if test="${isAdmin}"><td style="background: #f0f0f0"><input type="button" value="Edit" onclick="editUser(${user.id})"><input type="button" value="Delete" onclick="delUser(${user.id})"></td></c:if>--%>
                                </c:forEach>
                        </table>

         </td></tr>


        </table>
        <br>

</body>
</html>
