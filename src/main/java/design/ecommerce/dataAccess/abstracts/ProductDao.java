package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Transactional
    Integer deleteById(int id);
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameContainsIgnoreCaseAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategory_CategoryId(int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContainsIgnoreCase(String productName);

    List<Product> getByProductNameStartsWithIgnoreCase(String productName);
}
