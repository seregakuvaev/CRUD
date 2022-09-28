package web.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.Model.User;

import java.util.List;

@Service
public class ServiceDAOImp implements ServiceDAO{

    private final UserDAO userDAO;

    public ServiceDAOImp(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> list() {
        return userDAO.listUsers();
    }
}
