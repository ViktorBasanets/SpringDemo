package developer.service;

import developer.dao.ProductDao;
import developer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }
}
