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
        <title>Attendance Record</title>
        <link href="css/attendancerecord.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
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
        <form action="attend" method="POST">
            <input type="hidden" value="${session.sessionid}" name="sessionID" />
            <p>Attendance for <b>${session.group.sub.subjectname}</b> with lecturer <b>${session.taker.lname}</b> 
                at ${session.slot.slotname} on ${session.date} ,${session.room.roomname}</p>
            <table class="responstable">
                <tr>
                    <td>No</td>
                    <td>Group</td>
                    <td>Student Code</td>
                    <td>Student Name</td>
                    <td>Image</td>    
                    <td>Status</td>
                    <td>Comment</td>
                    <td>Taker</td>
                </tr>
                <c:forEach var="stu" items="${requestScope.students}">
                    <tr>

                        <td>${students.indexOf(stu)+1} </td>

                        <td> ${stu.group.get(0).gname}</td>
                        <td>
                            ${stu.scode}
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
                            <c:if test="${stu.stuAttend(session)}">
                               <p style="color: green">present</p> 
                            </c:if>                                       
                            <c:if test="${!stu.stuAttend(session)}">
                                <p style="color: red">absent</p>
                            </c:if>
                        </td>
                        <td></td>
                        <td>${session.taker.lname}</td>
                    </tr>

                </c:forEach>                                                                                        
            </table></br>
            <a href="attend?sessionID=${session.sessionid}" style="text-decoration: none">Edit</a>
        </form>
    </body>
</html>
