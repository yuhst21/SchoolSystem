/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author win
 */
public class Slot {
    private int slotid;
    private String slotname;
    private Time slotstart;
    private Time slotend;

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public String getSlotname() {
        return slotname;
    }

    public void setSlotname(String slotname) {
        this.slotname = slotname;
    }

    public Time getSlotstart() {
        return slotstart;
    }

    public void setSlotstart(Time slotstart) {
        this.slotstart = slotstart;
    }

    public Time getSlotend() {
        return slotend;
    }

    public void setSlotend(Time slotend) {
        this.slotend = slotend;
    }


    
}
