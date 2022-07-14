/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class AttendController extends HttpServlet {

    SessionDBContext dbSession = new SessionDBContext();
    StudentDBContext dbStudent = new StudentDBContext();
    AttendDBContext dbAttendance = new AttendDBContext();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("sessionID");
        Session s = new Session();
        s.setSessionid(Integer.parseInt(sid));
        Session session = dbSession.get(s);
        ArrayList<Student> students = dbStudent.list(s);
        request.setAttribute("students", students);
        request.setAttribute("session", session);
        request.setAttribute("attend", dbAttendance.list());
        request.getRequestDispatcher("/View/Attendance/attendance.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sesid = request.getParameter("sessionID");
        Session s = new Session();
        s.setSessionid(Integer.parseInt(sesid));
        Session session = dbSession.get(s);
        ArrayList<Student> students = dbStudent.list(s);

        for (Student stu : students) {
            Attendance attendance = new Attendance();
            boolean attend = request.getParameter("status" + stu.getSid()).equals("true");
            String comment = request.getParameter("comment" + stu.getSid());
            attendance.setAttend(attend);
            attendance.setComment(comment);
            attendance.setStudent(dbStudent.get(stu));
            Session ses = dbSession.get(s);
            ses.setStatus(true);
            dbSession.update(ses);
            attendance.setSession(ses);
            if (!dbAttendance.isExistAttend(attendance)) {
                dbAttendance.insert(attendance);
            } else {
                dbAttendance.update(attendance);
            }

        }
        /*  String[] components = request.getParameterValues("component");
        ArrayList<Attendance> attendlist = new ArrayList<>();
        for (String component : components) {
            int sid = Integer.parseInt(component);
            Attendance attend = new Attendance();
            Student stu = new Student();
            stu.setSid(sid);
            Session ses = new Session();
            ses.setSessionid(Integer.parseInt(sesid));
            String statusStr = request.getParameter("status" + sid);
            boolean status = statusStr.equals("present");
            attend.setStudent(stu);
            attend.setSession(ses);
            attend.setAttend(status);
            attendlist.add(attend);
        }*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
