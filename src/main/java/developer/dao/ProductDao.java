package developer.dao;

import developer.model.Product;

public interface ProductDao {
    Product getById(Long id);
}
