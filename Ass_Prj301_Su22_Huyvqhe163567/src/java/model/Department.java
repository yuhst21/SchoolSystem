/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Department {
    private int depid;
    private String depname;
    private ArrayList<Student> stulist ;
    private ArrayList<Lecture> leclist;

    public ArrayList<Student> getStulist() {
        return stulist;
    }

    public void setStulist(ArrayList<Student> stulist) {
        this.stulist = stulist;
    }

    public ArrayList<Lecture> getLeclist() {
        return leclist;
    }

    public void setLeclist(ArrayList<Lecture> leclist) {
        this.leclist = leclist;
    }

    
    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
    
}
