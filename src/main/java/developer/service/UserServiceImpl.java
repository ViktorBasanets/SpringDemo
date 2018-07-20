package developer.service;

import developer.dao.UserDao;
import developer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Override
    public User addUser(User user) {
        String hashedPassword = hasPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setToken(generateToken());
        mailService.notify(user);
        return userDao.addUser(user);
    }

    @Override
    public User getByEmail(User user) {
        return userDao.getByEmail(user);
    }



    private String hasPassword(String password) {
        return String.valueOf(Objects.hash(password));
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
