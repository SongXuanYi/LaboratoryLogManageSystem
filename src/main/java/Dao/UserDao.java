package Dao;

import UserBean.Logs;
import UserBean.User;

import java.util.List;

public interface UserDao {

    User findByNameAndPassword(String username, String password);

    List<Logs> findAll();

    int addUser(User user);

    int addLog(Logs logs);

    int deleteLog(Integer id);

    Logs findById(Integer id);

    int Update(Logs logs);

    List<Logs> findFuzzy(String search);
}
