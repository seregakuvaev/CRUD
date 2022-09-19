package web.Service;

import web.Model.User;

import java.util.List;

public interface ServiceDAO {
    void add(User user);

    void update(User user);

    void delete(int id);

    User getUser(int id);

    List<User> list();
}
