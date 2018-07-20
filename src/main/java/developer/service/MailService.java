package developer.service;

import developer.model.User;

public interface MailService {
    void notify(User user);
}
