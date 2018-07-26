package developer.dao;

import developer.model.Cart;
import developer.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cart addCart(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
        return getByUser(cart.getUser());
    }

    @Override
    public Cart getByUser(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Cart c" +
                        " join fetch c.products" +
                        " where c.id =: userId", Cart.class)
                .setParameter("userId", user.getId())
                .uniqueResult();
    }
}
