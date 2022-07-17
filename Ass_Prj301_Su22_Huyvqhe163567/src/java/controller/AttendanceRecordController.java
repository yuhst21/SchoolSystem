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
public class AttendanceRecordController extends BaseRequiredAuthenticationController {

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("sessionID");
        Session s = new Session();
        s.setSessionid(Integer.parseInt(sid));
        Session session = dbSession.get(s);
        ArrayList<Student> students = dbStudent.list(s);
        ArrayList<Attendance> attend = dbAttendance.list();
        for (Student student : students) {
            for (Attendance a : attend) {
                if (a.getStudent().getSid() == student.getSid()) {
                    student.getAttendance().add(a);
                }
            }
        }       
        request.setAttribute("students", students);
        request.setAttribute("session", session);
        request.setAttribute("attend", attend);
        request.getRequestDispatcher("/View/Attendance/attendancerecord.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("sessionID");
        Session s = new Session();
        s.setSessionid(Integer.parseInt(sid));
        Session ses = dbSession.get(s);
        response.sendRedirect("attend?sessionID=" + ses.getSessionid());
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
