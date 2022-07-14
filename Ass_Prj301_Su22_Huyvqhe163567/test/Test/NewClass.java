/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import dal.SessionDBContext;
import java.util.ArrayList;
import model.Session;

/**
 *
 * @author win
 */
public class NewClass {
    public static void main(String[] args) {
        SessionDBContext dbSession = new SessionDBContext();
        Session s = new Session();
        s.setSessionid(8);
        Session session = dbSession.get(s);
        System.out.println(session.getTaker().getLname());
        
    }
}
