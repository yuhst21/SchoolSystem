<%-- 
    Document   : viewgroup
    Created on : Jul 17, 2022, 3:05:28 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Group</title>
        <link href="css/viewgroup.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="hero">
            <nav>
                <ul>
                    <li><a href="schedule">Home</a></li>
                    <li><a href="grouplist">View Classes</a></li>
                    <li style="float:right">
                        <c:if test="${sessionScope.account ne null}">
                            <a href="logout">Logout</a>
                        </c:if>
                        <c:if test="${sessionScope.account eq null}">
                            <a href="login">Login</a>
                        </c:if>
                    </li>
                    <li style="float:right"><a>${sessionScope.acc.username}</a></li> 
                </ul>
            </nav> 
        </div>
                <div class="header"><h1>List classes of lecture ${sessionScope.lecture.lid}</h1> </div>
        <div >

            <table class="responstable">
                <tr>
                    <td>No</td>
                    <td>Group</td>
                    <td>Lecture</td>
                    <td>Subject</td>
                    <td>View Attendance</td>
                </tr>

                <c:forEach items="${requestScope.groups}" var="g">
                    <tr>
                        <td>${groups.indexOf(g)+1}</td>
                        <td>${g.gname}</td>
                        <td>${g.lec.lname}</td>
                        <td>${g.sub.subjectname}</td>
                        <td> <a href="stuattend?gid=${g.gid}">View</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
