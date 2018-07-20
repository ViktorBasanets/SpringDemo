package developer.service;

import developer.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(Long id);
}
