/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.ArrayList;
import model.Group;
import model.Student;

/**
 *
 * @author win
 */
public class NewClass {
    public static void main(String[] args) {
        
        ArrayList<Student> stu = new ArrayList<>();
        Student s = new Student();
        s.setSid(0);
        s.setSname("Huy");
        Group g = new Group();
        g.setGid(1);
        g.setGname("Se12");
        s.setGroup(new ArrayList<>());
        s.getGroup().add(g);
        stu.add(s);
        for (Student student : stu) {
            System.out.println(stu.size());
        }
    }
}
