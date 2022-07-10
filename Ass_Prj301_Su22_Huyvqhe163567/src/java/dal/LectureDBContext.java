/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Lecture;

/**
 *
 * @author win
 */
public class LectureDBContext extends DBContext<Lecture> {

    @Override
    public ArrayList<Lecture> list() {
        ArrayList<Lecture> lec = new ArrayList<>();
        try {
            String sql = "SELECT l.[lid],l.[lname],l.[lgender],l.[lcontract],l.[depid],d.depname\n"
                    + "  FROM [Lecture] l inner join Department d on l.depid = d.depid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                l.setLgender(rs.getBoolean("lgender"));
                l.setLcontract(rs.getString("lcontract"));
                Department d = new Department();
                d.setDepid(rs.getInt("depid"));
                d.setDepname(rs.getString("depname"));
                l.setDept(d);
                lec.add(l);
            }
            return lec;
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Lecture get(Lecture entity) {
        try {
            String sql = "Select l.lid,l.lname,l.lgender,l.lcontract,l.depid,d.depname from  Lecture l inner join Department d\n"
                    + "on l.depid = d.depid where l.lid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getLid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                l.setLgender(rs.getBoolean("lgender"));
                l.setLcontract(rs.getString("lcontract"));
                Department d = new Department();
                d.setDepid(rs.getInt("depid"));
                d.setDepname(rs.getString("depname"));
                l.setDept(d);
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
