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
import model.Group;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class NewClass {

    public static void main(String[] args) { String gid = "";
        StudentDBContext dbStudent = new StudentDBContext();
        AttendDBContext dbAttend = new AttendDBContext();
        Group group = new Group();
        group.setGid(3);
        ArrayList<Student> students = dbStudent.list(group);
        ArrayList<Attendance> attends = dbAttend.list();      
        for (Student student : students) {
            student.getAttendance().clear();
            for (Attendance attend : attends) {
                if (group.getGid()==attend.getSession().getGroup().getGid() &&
                        student.getSid() == attend.getStudent().getSid()) {
                    student.getAttendance().add(attend);
                 
                }
            }
        }
        for (Student stu : students) {
            System.out.println(stu.getAbsent());
        }
       
    }
}
