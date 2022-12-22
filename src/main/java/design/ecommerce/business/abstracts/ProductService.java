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

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
