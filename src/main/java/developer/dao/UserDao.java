package developer.dao;

import developer.model.User;

public interface UserDao {
    User addUser(User user);
    User getByEmail(User user);

}
