/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author win
 */
public class Attendance {
    private int attendid;
    private Student sid;
    private Session sessionid;

    public int getAttendid() {
        return attendid;
    }

    public void setAttendid(int attendid) {
        this.attendid = attendid;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    public Session getSessionid() {
        return sessionid;
    }

    public void setSessionid(Session sessionid) {
        this.sessionid = sessionid;
    }
    
}
