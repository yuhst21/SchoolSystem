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
        <link href="css/schedule.css" rel="stylesheet" type="text/css"/>
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
        <form action="schedule">
            <div class="body-content">
                Campus: <select>
                    <option> FU-HL</option>
                </select>  </br>
                Lecture: <input type="text" name="lecture" value="sonnt"> 
                <input type="submit" value="View"> </div>
        </form>

        <form action="schedule" method="POST" id="schedule_form">
            <div class="body-content1">
                <table border="1" style="width:70% " >
                    <tr style="height: 40px">
                        <td rowspan="2" style="width:15%">
                            Year: <select id="id">
                                <option value="value">2021</option>
                            </select>
                            <br/>
                            Week:
                            <select onchange="Select()" id="week" name="week_index">
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
                    <tr style="height: 40px">                   
                        <c:forEach var="days" begin="0" end="6">
                            <td>${requestScope.week.startDate.plusDays(days).getDayOfMonth()}/${requestScope.week.startDate.plusDays(days).getMonthValue()}</td>
                        </c:forEach>
                    </tr>
                    <c:forEach items="${requestScope.slots}" var="slot">
                        <tr style="height: 40px">
                            <td>${slot.slotname} </td>
                            <c:forEach var="i" begin="0" end="6">
                                <td style="width:12%">
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
                                                  (attended)-<a href="attendrecord?sessionID=${s.sessionid}">
                                                      View
                                                  </a>
                                              </c:if>                        
                                        </c:if>
                                    </c:forEach> 
                                </td>
                            </c:forEach>  
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </body>
    <script src="js/schedule.js" type="text/javascript"></script>
</html>
