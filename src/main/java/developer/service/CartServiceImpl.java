package developer.service;

import developer.dao.CartDao;
import developer.model.Cart;
import developer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public Cart addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public Cart getByUser(User user) {
        return cartDao.getByUser(user);
    }


}
