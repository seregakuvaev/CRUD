package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.Model.User;
import web.Util.HibernateConfig;

import javax.persistence.*;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
@Component
public class UserDAOImp implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
//    EntityManager entityManager = new HibernateConfig().entityManager();
//    @Autowired
//    @Qualifier("query")
//    EntityManager entityManager;
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
