package service.impl;

import Dao.UserDao;
import Dao.impl.UserDaoImpl;
import UserBean.Logs;
import UserBean.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();

    @Override
    public User findByNameAndPassword(String username, String password) {
        return dao.findByNameAndPassword(username, password);
    }

    @Override
    public List<Logs> findAll() {
        return dao.findAll();
    }

    @Override
    public int addUser(User user) {
        return  dao.addUser(user);
    }

    @Override
    public int addLog(Logs logs) {
        return dao.addLog(logs);
    }

    @Override
    public int deleteLog(Integer id) {
        return dao.deleteLog(id);
    }

    @Override
    public Logs findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public int Update(Logs logs) {
        return dao.Update(logs);
    }

    @Override
    public List<Logs> findFuzzy(String search) {
        return dao.findFuzzy(search);
    }
}
