/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.StudentDBContext;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author win
 */
public class Test {
    public static void main(String[] args) {
        StudentDBContext db = new StudentDBContext();
        ArrayList<Student> s = db.list();
        for (Student stu : s) {
            Student st = db.get(stu);
        }
    }
}
