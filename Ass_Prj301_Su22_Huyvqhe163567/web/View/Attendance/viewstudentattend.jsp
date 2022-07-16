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
        <table border="2">
            <tr id="head">
                <td>No</td>
                <td>Group</td>
                <td>Student Code</td>
                <td>Student Name</td>    
                <td>Absent</td>  
            <script>
                var content = document.getElementById("head");
                var html = "";
                for (var i = 1; i <= 20; i++) {
                    html += "<td>Slot " + i + " </td>";
                }
                content.innerHTML += html;
            </script>
        </tr>
        <c:forEach var="stu" items="${requestScope.students}">
            <tr>
                <td>${students.indexOf(stu)+1} </td>
                <td> ${stu.group.get(0).gname}</td>
                <td> ${stu.scode}
                    <input type="hidden"name="${stu.sid}" value="${stu.sid}">
                </td>
                <td>
                    ${stu.sname}
                    <input type="hidden"name="'studentName'+'${stu.sid}'" value="${stu.sname}">                        
                </td>                                                        
                <td>${stu.getAbsent()}/20</td>
                <c:if test="${stu.attendance.size() eq 0}"> 
                    <c:forEach begin="0" end="19" step="1" var="i">
                        <td>
                            not yet
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${stu.attendance.size() ne 0}">
                    <c:forEach begin="0" end="${stu.attendance.size()-1}" step="1" var="i">
                        <td>
                            ${stu.attendance.get(i).attend ? "present":"absent"}
                        </td>
                    </c:forEach>
                    <c:forEach begin="0" end="${20-stu.attendance.size()-1}" step="1" var="i">
                        <td>
                            not yet
                        </td>
                    </c:forEach>
                </c:if>
            </tr>
        </c:forEach>
    </table> 
</body>
</html>
