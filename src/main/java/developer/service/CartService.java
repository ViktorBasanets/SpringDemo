package developer.service;

import developer.model.Cart;
import developer.model.User;

public interface CartService {
    Cart addCart(Cart cart);
    Cart getByUser(User user);
}
