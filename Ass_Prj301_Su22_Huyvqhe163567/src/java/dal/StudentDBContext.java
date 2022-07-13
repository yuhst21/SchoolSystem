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
import model.Group;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> list(Group group) {
        ArrayList<Student> stu = new ArrayList<>();
        try {
            String sql = "select g.gid,g.[gname],s.[sid],s.sname  from [Group] g inner join Enroll e\n"
                    + "on g.gid = e.gid inner join Student s \n"
                    + "on s.[sid] = e.[sid]\n"
                    + "where g.[gid] = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getGid());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                stu.add(s);
            }
            return stu;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Student> list(Session session) {
        ArrayList<Student> stu = new ArrayList<>();
        try {
            String sql = "select stu.[sid],stu.sname from Student stu inner join\n"
                    + "(select e.sid from Session s inner join Enroll e on s.gid=e.gid\n"
                    + "where s.sessionID= ? ) a on stu.[sid]=a.[sid]";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, session.getSessionid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                stu.add(s);
            }
            return stu;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> stu = new ArrayList<>();
        try {
            String sql = "Select s.sid,s.sname,s.sgender,s.sdob,s.depid,d.depname from  Student s inner join Department d\n"
                    + "on s.depid = d.depid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSgender(rs.getBoolean("sgender"));
                s.setSdob(rs.getDate("sdob"));
                Department d = new Department();
                d.setDepid(rs.getInt("depid"));
                d.setDepname(rs.getString("depname"));
                s.setDep(d);
                stu.add(s);
            }
            return stu;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student get(Student entity) {
        try {
            String sql = "Select s.sid,s.sname,s.sgender,s.sdob,s.depid,d.depname from  Student s inner join Department d\n"
                    + "on s.depid = d.depid where s.sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getSid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSgender(rs.getBoolean("sgender"));
                s.setSdob(rs.getDate("sdob"));
                Department d = new Department();
                d.setDepid(rs.getInt("depid"));
                d.setDepname(rs.getString("depname"));
                s.setDep(d);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Student get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
