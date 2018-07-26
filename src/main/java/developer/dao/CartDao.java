package developer.dao;

import developer.model.Cart;
import developer.model.User;

public interface CartDao {
    Cart addCart(Cart cart);
    Cart getByUser(User user);
}
