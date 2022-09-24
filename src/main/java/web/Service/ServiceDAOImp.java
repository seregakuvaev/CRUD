package web.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAOImp;
import web.Model.User;

import java.util.List;

@Service
public class ServiceDAOImp implements ServiceDAO{

    UserDAOImp userDAOImp = new UserDAOImp();

    @Override
    @Transactional
    public void add(User user) {
        userDAOImp.addUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAOImp.updateUser(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAOImp.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAOImp.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> list() {
        return userDAOImp.listUsers();
    }
}
