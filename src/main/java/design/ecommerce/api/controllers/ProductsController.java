package design.ecommerce.api.controllers;

import design.ecommerce.business.abstracts.ProductService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @DeleteMapping(value = "/delete")
    public Result delete(@RequestBody Product product){
        return this.productService.delete(product);
    }

    @GetMapping(value = "/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping(value = "/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping(value = "/getAllSortedByProductNameAsc")
    public DataResult<List<Product>> getAllSortedByProductNameAsc(){
        return this.productService.getAllSortedByProductNameAsc();
    }

    @GetMapping(value = "/getAllSortedByProductNameDesc")
    public DataResult<List<Product>> getAllSortedByProductNameDesc(){
        return this.productService.getAllSortedByProductNameDesc();
    }

    @GetMapping(value = "/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping(value = "getByProductNameAndCategory_CategoryId")
    DataResult<Product> getByProductNameAndCategory_CategoryId
            (@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping(value = "/getByProductNameContainsIgnoreCaseAndCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameContainsIgnoreCaseAndCategory_CategoryId
            (@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameContainsIgnoreCaseAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping(value = "/getByCategoryId")
    public DataResult<List<Product>> getByCategory_CategoryId(@RequestParam("categoryId") int categoryId){
        return this.productService.getByCategory_CategoryId(categoryId);
    }

    @GetMapping(value = "/getByCategory_CategoryIdIn")
    public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam("categoryId") List<Integer> categories){
        return this.productService.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping(value = "/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContainsIgnoreCase(@RequestParam String productName){
        return this.productService.getByProductNameContainsIgnoreCase(productName);
    }

    @GetMapping(value = "/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWithIgnoreCase(@RequestParam String productName){
        return this.productService.getByProductNameStartsWithIgnoreCase(productName);
    }
}
