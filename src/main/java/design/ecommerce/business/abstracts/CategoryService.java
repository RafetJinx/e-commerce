package design.ecommerce.business.abstracts;

import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    Result addCategory(Category category);

    DataResult<List<Category>> getAll();
    //Pagination function
    DataResult<List<Category>> getAll(int pageNo, int pageSize);

    DataResult<List<Category>> getAllSortedByCategoryNameAsc();
    DataResult<List<Category>> getAllSortedByCategoryNameDesc();

    DataResult<Integer> deleteByCategoryId(int id);

    DataResult<Category> getByCategoryNameIgnoreCase(String categoryName);
    DataResult<List<Category>> getByCategoryNameContainsIgnoreCase(String categoryName);

    DataResult<List<Category>> getByDescriptionContains(String description);

    DataResult<List<Category>> getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String categoryName, String description);

    DataResult<List<Category>> getByCategoryNameStartingWith(String categoryName);
}
