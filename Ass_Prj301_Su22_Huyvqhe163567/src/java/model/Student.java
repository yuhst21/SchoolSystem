/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Student {

    private int sid;
    private String sname;
    private boolean sgender;
    private Date sdob;
    private Department dep;
    private ArrayList<Group> group;
    private String scode;
    private ArrayList<Attendance> attendance = new ArrayList<>();

    public ArrayList<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(ArrayList<Attendance> attendance) {
        this.attendance = attendance;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public ArrayList<Group> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Group> group) {
        this.group = group;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public boolean isSgender() {
        return sgender;
    }

    public void setSgender(boolean sgender) {
        this.sgender = sgender;
    }

    public Date getSdob() {
        return sdob;
    }

    public void setSdob(Date sdob) {
        this.sdob = sdob;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public boolean stuAttend(Session ses) {
        for (Attendance attend : attendance) {
            if (attend.getSession().getSessionid() == ses.getSessionid()) {
                if (attend.isAttend()) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getAbsent() {
        int count=0;
        for(Attendance a : attendance) {
            if(!a.isAttend()) count++;
        }
        return count;
    }

}
