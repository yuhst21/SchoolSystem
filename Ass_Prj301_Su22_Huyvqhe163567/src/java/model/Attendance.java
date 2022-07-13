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
    private Student student;
    private Session session;
    private boolean attend;
    private Lecture taker;

    public int getAttendid() {
        return attendid;
    }

    public void setAttendid(int attendid) {
        this.attendid = attendid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public Lecture getTaker() {
        return taker;
    }

    public void setTaker(Lecture taker) {
        this.taker = taker;
    }
    

    
}
