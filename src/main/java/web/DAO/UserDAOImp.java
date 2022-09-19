package web.DAO;

import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from users", User.class);
        query.executeUpdate();
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
