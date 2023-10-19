package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }
    public User show(int id){
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);

        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Transactional
    public void update(int id, User updatedUser){
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.contains(show(id)) ? show(id) : entityManager.merge(show(id)));
    }
}