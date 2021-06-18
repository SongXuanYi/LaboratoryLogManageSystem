package Dao.impl;

import Dao.UserDao;
import UserBean.Logs;
import UserBean.User;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection conn = null;
    private PreparedStatement pstat = null;
    private ResultSet rs = null;

    @Override
    public User findByNameAndPassword(String username, String password) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, username);
            pstat.setString(2, password);
            rs = pstat.executeQuery();

            User user = null;
            while (rs.next()) {
                user = new User();
                String uname = rs.getString("username");
                String pwd = rs.getString("password");
                user.setUsername(username);
                user.setPassword(password);
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Logs> findAll() {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from log";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            Logs logs = null;
            List<Logs> list = new ArrayList();
            while (rs.next()) {
                logs = new Logs();

                String username = rs.getString("username");
                String date = rs.getString("date");
                String type = rs.getString("type");
                String event = rs.getString("event");
                int id = rs.getInt("id");
                logs.setUsername(username);
                logs.setDate(date);
                logs.setType(type);
                logs.setEvent(event);
                logs.setId(id);

                list.add(logs);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }

        return null;
    }

    @Override
    public int addUser(User user) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user values (?,?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getUsername());
            pstat.setString(2, user.getPassword());

            int i = pstat.executeUpdate();
            return i;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }
        return 0;
    }

    @Override
    public int addLog(Logs logs) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into log (username,date,type,event,id) values (?,?,?,?,?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, logs.getUsername());
            pstat.setString(2, logs.getDate());
            pstat.setString(3, logs.getType());
            pstat.setString(4, logs.getEvent());
            pstat.setInt(5, logs.getId());
            int i = pstat.executeUpdate();
            return i;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }
        return 0;
    }

    @Override
    public int deleteLog(Integer id) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from log where id =?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            int i = pstat.executeUpdate();
            return i;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }
        return 0;
    }

    @Override
    public Logs findById(Integer id) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from log where id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            rs = pstat.executeQuery();
            Logs logs = null;
            while (rs.next()) {
                logs = new Logs();
                String username = rs.getString("username");
                String date = rs.getString("date");
                String type = rs.getString("type");
                String event = rs.getString("event");
                int ids = rs.getInt("id");
                logs.setId(ids);
                logs.setUsername(username);
                logs.setType(type);
                logs.setEvent(event);
                logs.setDate(date);
            }
            return logs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int Update(Logs logs) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update log set username=?,date=?,type=?,event=? where id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, logs.getUsername());
            pstat.setString(2, logs.getDate());
            pstat.setString(3, logs.getType());
            pstat.setString(4, logs.getEvent());
            pstat.setInt(5, logs.getId());
            int i = pstat.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }
        return 0;
    }

    @Override
    public List<Logs> findFuzzy(String search) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from log where ";
            StringBuffer sb = new StringBuffer(sql);
            List l = new ArrayList<>();
            if (search != null && search != "") {
                sb.append(" username like '%' ? '%' ");
                l.add(search);

                sb.append("or type like '%' ? '%' ");
                l.add(search);

                sb.append("or event like '%' ? '%' ");
                l.add(search);

                sb.append("or date like '%' ? '%' ");
                l.add(search);
            }
            System.out.println(sb.toString());
            pstat = conn.prepareStatement(sb.toString());
            for (int i = 1; i <= l.size(); i++) {
                pstat.setObject(i, l.get(i - 1));
            }
            rs = pstat.executeQuery();

            Logs logs = null;
            List<Logs> list = new ArrayList();
            while (rs.next()) {
                logs = new Logs();

                String username = rs.getString("username");
                String date = rs.getString("date");
                String type = rs.getString("type");
                String event = rs.getString("event");
                int id = rs.getInt("id");
                logs.setUsername(username);
                logs.setDate(date);
                logs.setType(type);
                logs.setEvent(event);
                logs.setId(id);

                list.add(logs);
            }

            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstat, conn);
        }
        return null;
    }
}
