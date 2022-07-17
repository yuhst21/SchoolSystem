<%-- 
    Document   : viewsinglestudentattend
    Created on : Jul 17, 2022, 11:58:36 AM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Student</title>
        <link href="css/viewsinglestudentattend.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>   
           <nav>
            <ul>
                <li><a href="schedule">Home</a></li>
                <li><a href="grouplist">View Classes</a></li>
                <li>
               
                </li>
            </ul>
        </nav> 
        <table border="1" style="width:30%">
            <tr id="head" style="height:25px">
                <td>No</td>
                <td>Group</td>
                <td>Slot</td>
                <td>Lecturer</td>
                <td>Date</td>
                <td>Attendance Status</td>              
            </tr>
            <c:forEach var="att" items="${requestScope.attendance}">
                <tr style="height:25px">
                    <td>${attendance.indexOf(att)+1}</td>
                    <td>${att.session.group.gname}</td>
                    <td>${att.session.slot.slotid}</td>
                    <td>${att.taker.lname}</td>                                                        
                    <td>${att.session.date}</td>
                    <td>
                        <c:if test="${att.attend eq true}">
                            Present
                        </c:if>
                        <c:if test="${att.attend ne true}">
                            Absent
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
                 </table> 
            <c:forEach var="stu" items="${requestScope.students}">
                   (${stu.getAbsent()} ABSENT ON 20 TOTAL)           
            </c:forEach>

       
    </body>
</html>
