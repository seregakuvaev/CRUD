package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
public class UserDAOImp implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete User where id = :first");
        query.setParameter("first", id);
        query.executeUpdate();
    }
}
