package design.ecommerce.business.concretes;

import design.ecommerce.business.abstracts.CategoryService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.core.utilities.results.dataResult.success.SuccessDataResult;
import design.ecommerce.core.utilities.results.successResult.SuccessResult;
import design.ecommerce.dataAccess.abstracts.CategoryDao;
import design.ecommerce.entities.concretes.Category;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Result addCategory(Category category) {
        this.categoryDao.save(category);
        return new SuccessResult("Kategori eklendi");
    }

    @Override
    public Result deleteCategory(Category category) {
        this.categoryDao.delete(category);
        return new SuccessResult("Kategori silindi");
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi", this.categoryDao.findAll());
    }

    @Override
    public DataResult<List<Category>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Category>> getAllSortedByCategoryNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "categoryName");
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi", this.categoryDao.findAll(sort));
    }

    @Override
    public DataResult<List<Category>> getAllSortedByCategoryNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "categoryName");
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi", this.categoryDao.findAll(sort));
    }

    @Override
    public DataResult<Category> getByCategoryName(String categoryName) {
        return new SuccessDataResult<Category>("Kategori Listelendi",
                this.categoryDao.getByCategoryName(categoryName));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameContains(String categoryName) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameContains(categoryName));
    }

    @Override
    public DataResult<List<Category>> getByDescriptionContains(String description) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByDescriptionContains(description));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameContainsOrDescriptionContains(String categoryName, String description) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameContainsOrDescriptionContains(categoryName, description));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameStartingWith(String categoryName) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameStartingWith(categoryName));
    }
}
