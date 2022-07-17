/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.AccountDBContext;
import dal.DateTimeHandle;
import dal.LectureDBContext;
import dal.SessionDBContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Account;
import model.Lecture;
import model.Session;
import model.Week;

/**
 *
 * @author win
 */
public class test2 {

    public static void main(String[] args) {
        DateTimeHandle dateTime = new DateTimeHandle();
        ArrayList<Week> weeks = dateTime.getWeeksOfYear();
        LocalDate currentDate = LocalDate.now();
        Week currentWeek = dateTime.getWeekByDate(weeks, currentDate);
        currentWeek.setStartDate(LocalDate.parse("2021-06-20"));
        currentWeek.setEndDate(LocalDate.parse("2021-06-27"));
        LectureDBContext ldb = new LectureDBContext();
        AccountDBContext db = new AccountDBContext();
        SessionDBContext sessionDB = new SessionDBContext();
        Account account = db.getByUsernamePassword("sonhx", "sonhx");
        if (account != null) {
            System.out.println(account.getUserid());
        } else {
            System.out.println("loi");
        }
        Lecture lec = ldb.getLectureAccount(account);
        System.out.println(lec.getLid());
        ArrayList<Session> sessions = sessionDB.listSessionByLecture(lec);
        for (Session session : sessions) {
            System.out.println(session.getGroup().getSub().getSubjectname() +session.getDate());
        }
    }
}
