/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.AttendDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class NewClass {

    public static void main(String[] args) {
        SessionDBContext dbSession = new SessionDBContext();
        StudentDBContext dbStudent = new StudentDBContext();
        AttendDBContext dbAttendance = new AttendDBContext();
        ArrayList<Attendance> att = dbAttendance.list();
        for (Attendance attendance : att) {
            System.out.println(attendance.isAttend());
        }
    }
}
