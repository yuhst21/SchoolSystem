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
import model.Slot;

/**
 *
 * @author win
 */
public class SlotDBContext extends DBContext<Slot> {

    @Override
    public ArrayList<Slot> list() {
        ArrayList<Slot> slot = new ArrayList<>();
        try {
            String sql = "select s.slotid,s.slotname,s.slotstart,s.slotend from Slot s";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlotid(rs.getInt("slotid"));
                s.setSlotname(rs.getString("slotname"));
                s.setSlotstart(rs.getDate("slotstart"));
                s.setSlotend(rs.getDate("slotend"));
                slot.add(s);
            }
            return slot;
        } catch (SQLException ex) {
            Logger.getLogger(SlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Slot get(Slot entity) {
        try {
            String sql = "select s.slotid,s.slotname,s.slotstart,s.slotend from Slot s\n"
                    + "where s.slotid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getSlotid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlotid(rs.getInt("slotid"));
                s.setSlotname(rs.getString("slotname"));
                s.setSlotstart(rs.getDate("slotstart"));
                s.setSlotend(rs.getDate("slotend"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public void insert(Slot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Slot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Slot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
