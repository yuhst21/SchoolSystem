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
import model.Group;
import model.Lecture;
import model.Subject;

/**
 *
 * @author win
 */
public class GroupDBContext extends DBContext<Group> {

    @Override
    public ArrayList<Group> list() {
        ArrayList<Group> group = new ArrayList<>();
        try {
            String sql = "select g.gid,g.gname,g.lid,g.subjectid,s.subjectname,l.lname,st.sname,st.depid \n"
                    + "from [Group] g inner join [Subject] s \n"
                    + "on g.subjectid = s.subjectid\n"
                    + "inner join Lecture l \n"
                    + "on g.lid = l.lid\n"
                    + "inner join Enroll e\n"
                    + "on g.gid = e.gid\n"
                    + "inner join Student st  \n"
                    + "on e.sid = st.sid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                Subject s = new Subject();
                s.setSubjectid(rs.getInt("subjectid"));
                s.setSubjectname(rs.getString("subjectname"));
                g.setSub(s);
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                g.setLec(l);                             
                group.add(g);
            }
            return group;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Group get(Group entity) {
        try {
            String sql = "select g.gid,g.gname,g.lid,g.subjectid,s.subjectname,l.lname,st.sname,st.depid \n"
                    + "from [Group] g inner join [Subject] s \n"
                    + "on g.subjectid = s.subjectid\n"
                    + "inner join Lecture l \n"
                    + "on g.lid = l.lid\n"
                    + "inner join Enroll e\n"
                    + "on g.gid = e.gid\n"
                    + "inner join Student st  \n"
                    + "on e.sid = st.sid\n"
                    + "where g.gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getGid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));
                Subject s = new Subject();
                s.setSubjectid(rs.getInt("subjectid"));
                s.setSubjectname(rs.getString("subjectname"));
                g.setSub(s);
                Lecture l = new Lecture();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                g.setLec(l);
                return g;

            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
