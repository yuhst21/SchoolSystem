/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.DateTimeHandle;
import dal.GroupDBContext;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Group;
import model.Lecture;

/**
 *
 * @author win
 */
public class NewClass1 {

    public static void main(String[] args) {
        Lecture lec = new Lecture();
        lec.setLid(1);
        GroupDBContext dbGroup = new GroupDBContext();
        ArrayList<Group> groups = dbGroup.list(lec);
        for (Group group : groups) {
            System.out.println(group.getLec().getLname());
        }
    }

}
