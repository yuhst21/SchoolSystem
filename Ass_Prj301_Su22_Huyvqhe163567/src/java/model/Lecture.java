/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author win
 */
public class Lecture {
    private int lid;
    private String lname;
    private boolean lgender;
    private String lcontract;
    private Department dept;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isLgender() {
        return lgender;
    }

    public void setLgender(boolean lgender) {
        this.lgender = lgender;
    }

    public String getLcontract() {
        return lcontract;
    }

    public void setLcontract(String lcontract) {
        this.lcontract = lcontract;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
    
}
