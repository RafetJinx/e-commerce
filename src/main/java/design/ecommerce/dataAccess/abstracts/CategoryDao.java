package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category getByCategoryName(String categoryName);
    List<Category> getByCategoryNameContains(String categoryName);

    List<Category> getByDescriptionContains(String description);

    List<Category> getByCategoryNameContainsOrDescriptionContains(String categoryName, String description);

    List<Category> getByCategoryNameStartingWith(String categoryName);
}
