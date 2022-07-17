/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Slot;
import model.Student;
import model.Subject;

/**
 *
 * @author win
 */
public class SessionDBContext extends DBContext<Session> {

    GroupDBContext gdb = new GroupDBContext();
    LectureDBContext ldb = new LectureDBContext();
    SubjectDBContext sdb = new SubjectDBContext();

    public ArrayList<Session> listSessionByLecture(Lecture lec, LocalDate startDate, LocalDate endDate) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {

            String sql = "select s.sessionid,s.roomid,r.roomname,s.slotid,sl.slotname,g.gid,g.gname,g.subjectid,sub.subjectname,s.[date],s.[status],s.taker \n"
                    + "from [Session] s \n"
                    + "inner join Room r on s.roomid = r.roomid\n"
                    + "inner join Slot sl on s.slotid = sl.slotid\n"
                    + "inner join [Group] g on s.gid = g.gid      \n"
                    + "inner join [Subject] sub on g.subjectid = sub.subjectid\n"
                    + "where s.[date] >= ? and s.[date] <= ? and s.taker = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, Date.valueOf(startDate));
            stm.setDate(2, Date.valueOf(endDate));
            stm.setInt(3, lec.getLid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setSessionid(rs.getInt("sessionid"));
                s.setDate(rs.getDate("date"));
                Room r = new Room();
                r.setRoomid(rs.getInt("roomid"));
                r.setRoomname(rs.getString("roomname"));
                s.setRoom(r);
                s.setStatus(rs.getBoolean("status"));
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                Subject sub = new Subject();
                sub.setSubjectid(rs.getInt("subjectid"));
                sub.setSubjectname(rs.getString("subjectname"));
                g.setSub(sub);
                s.setGroup(g);
                Slot slot = new Slot();
                slot.setSlotid(rs.getInt("slotid"));
                slot.setSlotname(rs.getString("slotname"));
                s.setSlot(slot);
                sessions.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    @Override
    public ArrayList<Session> list() {
        ArrayList<Session> session = new ArrayList<>();
        ArrayList<Student> stud = new ArrayList<>();
        try {
            String sql = "select s.sessionid,s.roomid,r.roomname,s.slotid,sl.slotname,g.gid,g.gname,g.lid,l.lname,g.subjectid,sub.subjectname,s.[date],stu.[sid],stu.sname,stu.scode from [Session] s \n"
                    + "                   inner join Room r on s.roomid = r.roomid\n"
                    + "                    inner join Slot sl on s.slotid = sl.slotid\n"
                    + "                   inner join [Group] g on s.gid = g.gid\n"
                    + "                    inner join Lecture l on g.lid = l.lid\n"
                    + "                   inner join [Subject] sub on g.subjectid = sub.subjectid\n"
                    + "				   inner join Enroll e on e.gid = g.gid\n"
                    + "				   inner join Student stu on e.sid = g.gid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setSessionid(rs.getInt("sessionid"));
                Room r = new Room();
                r.setRoomid(rs.getInt("roomid"));
                r.setRoomname(rs.getString("roomname"));
                s.setRoom(r);
                Slot sl = new Slot();
                sl.setSlotid(rs.getInt("slotid"));
                sl.setSlotname(rs.getString("slotname"));
                s.setSlot(sl);
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                Student stu = new Student();
                stu.setSid(rs.getInt("sid"));
                stu.setSname(rs.getString("sname"));
                stu.setScode(rs.getString("scode"));
                stud.add(stu);
                g.setStu(stud);
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                g.setLec(l);
                Subject sub = new Subject();
                sub.setSubjectid(rs.getInt("subjectid"));
                sub.setSubjectname(rs.getString("subjectname"));
                g.setSub(sub);
                s.setGroup(g);
                s.setDate(rs.getDate("date"));
                session.add(s);

            }
            return session;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkAttendance(Session entity) {
        try {
            String sql = "select s.[status] from [Session] s where s.sessionID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getSessionid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("status")) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Session get(Session entity) {
        try {
            String sql = "select s.sessionid,s.roomid,r.roomname,s.slotid,sl.slotname,g.gid,g.gname,g.lid,l.lname,g.subjectid,sub.subjectname,s.[date],s.[status],s.taker from [Session] s\n"
                    + "inner join Room r on s.roomid = r.roomid\n"
                    + "inner join Slot sl on s.slotid = sl.slotid\n"
                    + "inner join [Group] g on s.gid = g.gid\n"
                    + "inner join Lecture l on g.lid = l.lid\n"
                    + "inner join [Subject] sub on g.subjectid = sub.subjectid\n"
                    + "where s.sessionid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getSessionid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setSessionid(rs.getInt("sessionid"));
                Room r = new Room();
                r.setRoomid(rs.getInt("roomid"));
                r.setRoomname(rs.getString("roomname"));
                s.setRoom(r);
                Slot sl = new Slot();
                sl.setSlotid(rs.getInt("slotid"));
                sl.setSlotname(rs.getString("slotname"));
                s.setSlot(sl);
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                Subject sub = new Subject();
                sub.setSubjectid(rs.getInt("subjectid"));
                sub.setSubjectname(rs.getString("subjectname"));
                g.setSub(sdb.get(sub));
                s.setGroup(g);
                s.setDate(rs.getDate("date"));
                s.setStatus(rs.getBoolean("status"));
                s.setTaker(l);
                return s;

            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session entity) {
        try {
            String sql = "UPDATE [Session]\n"
                    + "   SET [status] = ?\n"
                    + " WHERE sessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, entity.isStatus());
            stm.setInt(2, entity.getSessionid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
