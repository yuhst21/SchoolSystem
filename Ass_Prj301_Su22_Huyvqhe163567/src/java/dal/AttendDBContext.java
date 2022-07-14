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
import model.Attendance;
import model.Lecture;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class AttendDBContext extends DBContext<Attendance> {

    @Override
    public ArrayList<Attendance> list() {
        ArrayList<Attendance> attend = new ArrayList<>();
        StudentDBContext sdb = new StudentDBContext();
        LectureDBContext ldb = new LectureDBContext();
        try {
            String sql = "select a.attendid,a.[sid],s.sname,a.attend,a.taker,l.lname from \n"
                    + "Attendance a inner join Student s on a.[sid] = s.[sid]\n"
                    + "inner join Lecture l on a.taker = l.lid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAttendid(rs.getInt("attendid"));
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                a.setStudent(sdb.get(s));
                a.setAttend(rs.getBoolean("attend"));
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                a.setTaker(ldb.get(l));
                attend.add(a);
            }
            return attend;
        } catch (SQLException ex) {
            Logger.getLogger(AttendDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Attendance> existedAttendances(Session entity) {
        boolean checkExist = false;
        ArrayList<Attendance> attend = new ArrayList<>();
        try {
            String sql = "select a.aid,a.[sid],a.attend from Attendance a where sessionID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getSessionid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                checkExist = true;
                Attendance a = new Attendance();
                a.setAttendid(rs.getInt("aid"));
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                a.setStudent(s);
                a.setAttend(rs.getBoolean("attend"));
                attend.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!checkExist) {
            attend = null;
        }
        return attend;
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        try {
            String sql = "INSERT INTO [Attendance]\n"
                    + "           ([sid]\n"
                    + "           ,[sessionid]\n"
                    + "           ,[attend]\n"
                    + "           ,[comment])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getStudent().getSid());
            stm.setInt(2, entity.getSession().getSessionid());
            stm.setBoolean(3, entity.isAttend());
            stm.setString(4, entity.getComment());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Attendance entity) {
        try {
            String sql = "UPDATE [Attendance]\n"
                    + "   SET [attend] = ?\n"
                    + " WHERE Attendance.aid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, entity.isAttend());
            stm.setInt(2, entity.getAttendid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
