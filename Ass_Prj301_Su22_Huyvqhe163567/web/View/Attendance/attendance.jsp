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
            Attendance for <b>${sessionScope.subject.subjectname}</b> with lecturer <b>${sessionScope.lecturer.lname}</b>
            <table>
                <tr>
                    <th style="border: solid;">NO</th>
                    <th style="border: solid;">GROUP</th>
                    <th style="border: solid;">CODE</th>
                    <th style="border: solid;">NAME</th>
                    <th style="border: solid;">IMAGE</th>
                    <th style="border: solid;">STATUS</th>
                    <th style="border: solid;">COMMENT</th>
                    <th style="border: solid;">TAKER</th>
                </tr>
                <tr>
                    <c:forEach items="${requestScope.group}" var="g">
                    <td>cell</td>
                    </c:forEach>
                </tr>
            </table>
            
        </form>
    </body>
</html>
