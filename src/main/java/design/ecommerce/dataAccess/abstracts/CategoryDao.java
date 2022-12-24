package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Transactional
    Integer deleteByCategoryId(int id);

    Category getByCategoryNameIgnoreCase(String categoryName);
    List<Category> getByCategoryNameContainsIgnoreCase(String categoryName);

    List<Category> getByDescriptionContains(String description);

    List<Category> getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String categoryName, String description);

    List<Category> getByCategoryNameStartingWith(String categoryName);
}
