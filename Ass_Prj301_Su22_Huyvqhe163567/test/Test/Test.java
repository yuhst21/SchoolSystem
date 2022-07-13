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
public class Test {
    public static void main(String[] args) {     
     SessionDBContext dbSession = new SessionDBContext();
    StudentDBContext dbStudent = new StudentDBContext();
    AttendDBContext dbAttendance = new AttendDBContext();
    
        Session s = new Session();
        s.setSessionid(7);
        
        ArrayList<Student> students = dbStudent.list(s);
        for (Student st : students) {
            System.out.println(st.getSname());
        }
        ArrayList<Attendance> attendExist = dbAttendance.existedAttendances(s);
        for (Attendance a : attendExist) {
            System.out.println(a.isAttend());
        }
    }
}
