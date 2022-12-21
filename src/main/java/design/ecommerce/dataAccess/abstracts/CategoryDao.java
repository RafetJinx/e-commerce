package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category getByCategoryId(int categoryId);
    Category getByCategoryName(String categoryName);
    Category getByDescription(String description);

    Category getByCategoryIdAndCategoryName(int categoryId, String categoryName);
    Category getByCategoryNameAndDescription(String categoryName, String description);
    Category getByCategoryIdAndCategoryNameAndDescription(int categoryId, String description);

    List<Category> getByCategoryNameContains(String categoryName);
    List<Category> getByCategoryNameStartingWith(String categoryName);
}
