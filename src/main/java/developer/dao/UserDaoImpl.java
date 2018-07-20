package developer.dao;

import developer.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return getByEmail(user);
    }

    @Override
    public User getByEmail(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("select u from User u join fetch u.roles where u.email =: email", User.class)
                .setParameter("email", user.getEmail())
                .uniqueResult();
    }
}
