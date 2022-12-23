package design.ecommerce.business.abstracts;

import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Result add(Product product);

    Result delete(Product product);

    DataResult<List<Product>> getAll();

    //Pagination function
    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSortedByProductNameAsc();

    DataResult<List<Product>> getAllSortedByProductNameDesc();

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameContainsIgnoreCaseAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategory_CategoryId(int categoryId);

    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContainsIgnoreCase(String productName);

    DataResult<List<Product>> getByProductNameStartsWithIgnoreCase(String productName);
}
