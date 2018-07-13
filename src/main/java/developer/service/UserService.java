package developer.service;

import developer.model.User;

public interface UserService {
    User addUser(User user);
    User getByEmail(User user);
}
