package developer.dao;

import developer.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    //private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
*/
    @Override
    public User addUser(User user) {
        /*this.jdbcTemplate.update(
                "INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN) VALUES (?, ?, ?, ?, ?)",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getToken()
        );
        return getByEmail(user);*/
        //user.setId(null);
        Session session = sessionFactory.getCurrentSession();
        session.save("User", user);

        return user;
    }

    @Override
    public User getByEmail(User user) {
        User u = sessionFactory.getCurrentSession()
                .createQuery("from User u where u.email =: email", User.class)
                .setParameter("email", user.getEmail())
                .uniqueResult();
        return u;
    }

    /*@Override
    public User getByEmail(User user) {
        return this.jdbcTemplate.queryForObject(
                "SELECT ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN FROM USERS U WHERE U.EMAIL = ?",
                new Object[] {user.getEmail()},
                (rs, i) -> {
                    User u = new User();
                    u.setId(rs.getLong("ID"));
                    u.setFirstName(rs.getString("FIRST_NAME"));
                    u.setLastName(rs.getString("LAST_NAME"));
                    u.setEmail(rs.getString("EMAIL"));
                    u.setPassword(rs.getString("PASSWORD"));
                    u.setToken(rs.getString("TOKEN"));
                    return u;
                }
        );
    }*/
}
