/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author win
 */
public class Session {
    private int sessionid ;
    private String sessionname;
    private Room roomid;
    private Slot slotid;
    private Group gid;
    private Date sessionstart;
    private Date sessionend;

    public int getSessionid() {
        return sessionid;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }

    public String getSessionname() {
        return sessionname;
    }

    public void setSessionname(String sessionname) {
        this.sessionname = sessionname;
    }

    public Room getRoomid() {
        return roomid;
    }

    public void setRoomid(Room roomid) {
        this.roomid = roomid;
    }

    public Slot getSlotid() {
        return slotid;
    }

    public void setSlotid(Slot slotid) {
        this.slotid = slotid;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    public Date getSessionstart() {
        return sessionstart;
    }

    public void setSessionstart(Date sessionstart) {
        this.sessionstart = sessionstart;
    }

    public Date getSessionend() {
        return sessionend;
    }

    public void setSessionend(Date sessionend) {
        this.sessionend = sessionend;
    }
    
}
