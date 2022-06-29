/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.SessionDBContext;
import java.util.ArrayList;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class Test {
    public static void main(String[] args) {
        SessionDBContext sdb = new  SessionDBContext();
        ArrayList<Session> s = sdb.list();
        for (Session ss : s) {
            System.out.println(ss.getSlot().getSlotstart());
        }
    }
}
