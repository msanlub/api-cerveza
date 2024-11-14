package daw2a.gestionbiblioteca.services;

import daw2a.gestionbiblioteca.entities.Category;
import daw2a.gestionbiblioteca.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // CRUD operations
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = getCategoryById(id);
        category.setCatName(categoryDetails.getCatName());
        category.setLastMod(categoryDetails.getLastMod());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    //por nombre
    public List<Category> findCategoriesByName(String name) {
        return categoryRepository.findByCatNameContainingIgnoreCase(name);
    }
}
