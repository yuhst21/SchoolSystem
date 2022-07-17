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
        <title>View Student</title>
        <link href="css/viewstudentattend.css" rel="stylesheet" type="text/css"/>
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
            </ul>
        </nav> 
        <table border="1" style="width:30%"> 
            <tr id="head" style="height:25px">
                <td style="width:3%">No</td>
                <td>Group</td>
                <td>Student Code</td>
                <td>Student Name</td>    
                <td>Absent</td>             
            </tr>
            <c:forEach var="stu" items="${requestScope.students}">
                <tr style="height:25px">
                    <td>${students.indexOf(stu)+1} </td>
                    <td> ${stu.group.get(0).gname}</td>
                    <td>  <a href="viewsinglestu?sid=${stu.sid}" 
                             style="text-decoration: none"
                             >${stu.scode} </a>
                        <input type="hidden"name="${stu.sid}" value="${stu.sid}">
                    </td>
                    <td>
                        ${stu.sname}
                        <input type="hidden"name="'studentName'+'${stu.sid}'" value="${stu.sname}">                        
                    </td>                                                        
                    <td>${stu.getAbsent()}/20</td>              
                </tr>
            </c:forEach>
        </table> 
    </body>
</html>
