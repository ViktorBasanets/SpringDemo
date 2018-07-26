package developer.dao;

import developer.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product getById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select p from Product p where p.id =: id", Product.class)
                .setParameter("id", id)
                .uniqueResult();
    }
}
