<%-- 
    Document   : schedule
    Created on : Jul 12, 2022, 11:14:41 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule</title>   
    </head>
    <body>
        <form action="schedule">
            <div >
                Campus: <select>
                    <option> FU-HL</option>
                </select>  </br>
                Lecture: <input type="text" name="lecture" value="sonnt"> 
                <input type="submit" value="View"> </div>
        </form>

        <form action="schedule" method="POST" id="schedule_form" >
            <table border="1" >
                <tr>
                    <td rowspan="2">
                        Year: 2022 <br/>
                        Week:
                        <select onchange="Select()">
                            <c:forEach items="${sessionScope.weeks}" var="w">
                                <option  value="${sessionScope.weeks.indexOf(w)}"
                                         <c:forEach var="i" begin="0" end="6">
                                             <c:if test="${requestScope.date eq w.startDate.plusDays(i)}">
                                                 selected = "selected";
                                             </c:if>
                                         </c:forEach> >
                                    ${w.startDate.getDayOfMonth()}/${w.startDate.getMonthValue()} To 
                                    ${w.endDate.getDayOfMonth()}/${w.endDate.getMonthValue()}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>Mon</td>
                    <td>Tue</td>
                    <td>Wed</td>
                    <td>Thu</td>
                    <td>Fri</td>
                    <td>Sat</td>
                    <td>Sun</td>
                </tr>
                <tr>                   
                    <c:forEach var="days" begin="1" end="7">
                        <td>${requestScope.week.startDate.plusDays(days).getDayOfMonth()}/${requestScope.week.startDate.plusDays(days).getMonthValue()}</td>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.slots}" var="slot">
                    <tr>
                        <td>${slot.slotname} </td>
                        <c:forEach var="i" begin="0" end="6">
                            <td>
                                <c:forEach items="${requestScope.sessions}" var="s">
                                    <c:if test="${s.slot.slotid eq slot.slotid and 
                                                  requestScope.week.startDate.plusDays(i) eq s.date.toLocalDate()}">
                                          <a href="attend?sessionID=${s.sessionid}">
                                              ${s.group.sub.subjectname}
                                          </a> - <br/> at ${s.room.roomname} <br/> 
                                          <c:if test="${s.status ne true}">
                                              (not yet)
                                          </c:if>
                                          <c:if test="${s.status eq true}">
                                              (attended)
                                          </c:if>                        
                                    </c:if>
                                </c:forEach> 
                            </td>
                        </c:forEach>  
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
    <script src="js/schedule.js" type="text/javascript"></script>
</html>
