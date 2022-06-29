<%-- 
    Document   : lecturetimetable
    Created on : Jun 29, 2022, 10:41:15 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="lec" method="POST">
            Campus: <br/>
            Lecture: <br/>
            <table border="1">
                <tr >
                    <td rowspan="2"> Year:</br>
                        Week:
                    </td>
                    <td>cell</td>
                    <td>cell</td>
                </tr>
                <tr>
                    <td>cell</td>
                    <td>cell</td>
                </tr>

                <c:forEach items="${requestScope.slot}" var="sl">
                    <tr>
                        <td> ${sl.slotname}</td>
                        <c:forEach items="${requestScope.session}" var="ses">
                            <td>${ses.group.sub.subjectname} <br/>
                                ${ses.room.roomname} <br/>

                            </td>
                        </c:forEach>
                    </tr>

                </c:forEach>







            </table>

        </form>
    </body>
</html>
