package design.ecommerce.business.concretes;

import design.ecommerce.business.abstracts.ProductService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.core.utilities.results.dataResult.success.SuccessDataResult;
import design.ecommerce.core.utilities.results.successResult.SuccessResult;
import design.ecommerce.dataAccess.abstracts.ProductDao;
import design.ecommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>("Data Listelendi", this.productDao.findAll());
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSortedByProductNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return new SuccessDataResult<List<Product>>("Listeleme Başarılı", this.productDao.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAllSortedByProductNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>("Listeleme Başarılı", this.productDao.findAll(sort));
    }

    @Override
    public DataResult<Integer> deleteById(int id) {
        return new SuccessDataResult<Integer>("Ürün Silindi", this.productDao.deleteById(id));
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>("Data Listelendi", this.productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>("Data Listelendi",
                this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContainsIgnoreCaseAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",
                this.productDao.getByProductNameContainsIgnoreCaseAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryId(int categoryId) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",
                this.productDao.getByCategory_CategoryId(categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",
                this.productDao.getByCategory_CategoryIdIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContainsIgnoreCase(String productName) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",
                this.productDao.getByProductNameContainsIgnoreCase(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWithIgnoreCase(String productName) {
        return new SuccessDataResult<List<Product>>("Data Listelendi",
                this.productDao.getByProductNameStartsWithIgnoreCase(productName));
    }
}
