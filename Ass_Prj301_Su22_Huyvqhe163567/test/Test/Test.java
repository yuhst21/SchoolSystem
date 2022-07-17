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
public class Test {

    public static void main(String[] args) {
        StudentDBContext dbStudent = new StudentDBContext();
        AttendDBContext dbAttend = new AttendDBContext();
        SessionDBContext dbSession = new SessionDBContext();
        AttendDBContext dbAttendance = new AttendDBContext();
        int gid = 3;
        Group group = new Group();
        group.setGid(3);
        Student students1 = new Student();
        students1.setSid(1);
        ArrayList<Student> students = dbStudent.get(group, students1);
        ArrayList<Attendance> attends = dbAttendance.listOneAttend(students1, group);
        for (Student student : students) {
            student.getAttendance().clear();
            for (Attendance attend : attends) {
                if (group.getGid() == attend.getSession().getGroup().getGid()
                        && student.getSid() == attend.getStudent().getSid()) {
                    student.getAttendance().add(attend);
                }
            }
        }
        for (Attendance attend : attends) {
            System.out.println(attend.getStudent().getAbsent());
        }

        for (Student stu : students) {
            System.out.println(stu.getAbsent());
        }

    }
}
