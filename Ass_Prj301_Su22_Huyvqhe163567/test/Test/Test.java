/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import controller.ScheduleController;
import dal.LectureDBContext;
import dal.SessionDBContext;
import dal.SlotDBContext;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Lecture;
import model.Session;
import model.Slot;
import model.Week;

/**
 *
 * @author win
 */
public class Test {
    public static void main(String[] args) {     
        SessionDBContext sdb = new SessionDBContext();
        ScheduleController s = new ScheduleController();
        ArrayList<Week> weeks = s.getWeeksOfYear();
        LocalDate currentDate = LocalDate.now();
        Week currentWeek = s.getWeekByDate(weeks, currentDate);
         Lecture lec = new Lecture();
        lec.setLid(1);
        ArrayList<Session> 
         sessions = sdb.listSessionByLecture(lec, currentWeek.getStartDate(), currentWeek.getEndDate());
        for (Session ses : sessions) {
            System.out.println(ses.getClass());
        }
    }
}
