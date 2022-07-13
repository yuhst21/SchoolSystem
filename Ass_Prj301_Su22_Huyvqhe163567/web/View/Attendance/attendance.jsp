<%-- 
    Document   : attendance
    Created on : Jun 29, 2022, 10:40:14 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <form action="attend" method="POST">
            <input type="hidden" value="${session.sessionid}" name="sessionID" />
            <table border="2">
                <tr >
                    <td>
                        Student ID
                    </td>
                    <td>
                        Student Name
                    </td>
                    <td>
                        Avatar
                    </td>    
                    <td>
                        Status
                    </td>
                </tr>
                <c:forEach var="stu" items="${requestScope.students}">
                    <tr>
                        <td>
                            ${stu.sid}
                            <input type="hidden"name="${stu.sid}" value="${stu.sid}">
                        </td>
                        <td>
                            ${stu.sname}
                            <input type="hidden"name="'studentName'+'${stu.sid}'" value="${stu.sname}">                        
                        </td>                         
                        <td>
                            <img src="img/empty-avatar.jpg" alt=""/>
                        </td>
                       
                        <td>
                           
                        </td>
                    </tr>
                </c:forEach>
            </table> </br>
            <input type="submit" value="Save" />
           
            
        </form>
    </body>
</html>
