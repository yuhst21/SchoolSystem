/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.LectureDBContext;
import dal.SlotDBContext;
import java.util.ArrayList;
import model.Lecture;
import model.Slot;

/**
 *
 * @author win
 */
public class Test {
    public static void main(String[] args) {
        SlotDBContext sdb = new SlotDBContext();
        ArrayList<Slot> slot = sdb.list();
        for (Slot s : slot) {
            System.out.println(s.getSlotname());
        }
        LectureDBContext ldb = new LectureDBContext();
        ArrayList<Lecture> lec = ldb.list();
        for (Lecture l : lec) {
            System.out.println(ldb.get(l).getLname());
        }
    }
}
