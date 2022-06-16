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
public class Slot {
    private int slotid;
    private String slotname;
    private Date slotstart;
    private Date slotend;

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

    public Date getSlotstart() {
        return slotstart;
    }

    public void setSlotstart(Date slotstart) {
        this.slotstart = slotstart;
    }

    public Date getSlotend() {
        return slotend;
    }

    public void setSlotend(Date slotend) {
        this.slotend = slotend;
    }
    
}
