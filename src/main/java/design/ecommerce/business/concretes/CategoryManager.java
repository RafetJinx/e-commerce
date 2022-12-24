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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi", this.categoryDao.findAll());
    }

    @Override
    public DataResult<List<Category>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
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
    public DataResult<Integer> deleteByCategoryId(int id) {
        return new SuccessDataResult<Integer>("Kategori Silindi", this.categoryDao.deleteByCategoryId(id));
    }

    @Override
    public DataResult<Category> getByCategoryNameIgnoreCase(String categoryName) {
        return new SuccessDataResult<Category>("Kategori Listelendi",
                this.categoryDao.getByCategoryNameIgnoreCase(categoryName));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameContainsIgnoreCase(String categoryName) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameContainsIgnoreCase(categoryName));
    }

    @Override
    public DataResult<List<Category>> getByDescriptionContains(String description) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByDescriptionContains(description));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String categoryName, String description) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(categoryName, description));
    }

    @Override
    public DataResult<List<Category>> getByCategoryNameStartingWith(String categoryName) {
        return new SuccessDataResult<List<Category>>("Kategoriler Listelendi",
                this.categoryDao.getByCategoryNameStartingWith(categoryName));
    }
}
