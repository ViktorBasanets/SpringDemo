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

    //private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User addUser(User user) {
        this.jdbcTemplate.update(
                "INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN) VALUES (?, ?, ?, ?, ?)",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getToken()
        );
        return getByEmail(user);
}

*/

    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return getByEmail(user);
    }

    /*@Override
    public User getByEmail(User user) {
        user.setId(19L);
        return sessionFactory
                .getCurrentSession()
                .get(User.class, user.getId());
    }
*/
    @Override
    public User getByEmail(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User u where u.email =: email", User.class)
                .setParameter("email", user.getEmail())
                .uniqueResult();
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
