package design.ecommerce.api.controllers;

import design.ecommerce.business.abstracts.CategoryService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.dataAccess.abstracts.CategoryDao;
import design.ecommerce.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/add")
    Result addCategory(@RequestBody Category category){
        return this.categoryService.addCategory(category);
    }

    @DeleteMapping(value = "/delete")
    Result deleteCategory(@RequestBody Category category){
        return this.categoryService.deleteCategory(category);
    }

    @GetMapping(value = "/getAll")
    DataResult<List<Category>> getAll(){
        return this.categoryService.getAll();
    }
    @GetMapping(value = "/getAllByPage")
    DataResult<List<Category>> getAll(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return this.categoryService.getAll(pageNo, pageSize);
    }

    @GetMapping(value = "/getAllSortedByCategoryNameAsc")
    DataResult<List<Category>> getAllSortedByCategoryNameAsc(){
        return this.categoryService.getAllSortedByCategoryNameAsc();
    }
    @GetMapping(value = "/getAllSortedByCategoryNameDesc")
    DataResult<List<Category>> getAllSortedByCategoryNameDesc(){
        return this.categoryService.getAllSortedByCategoryNameDesc();
    }

    @GetMapping(value = "/getByCategoryName")
    DataResult<Category> getByCategoryNameIgnoreCase(@RequestParam String categoryName){
        return this.categoryService.getByCategoryNameIgnoreCase(categoryName);
    }
    @GetMapping(value = "/getByCategoryNameContains")
    DataResult<List<Category>> getByCategoryNameContainsIgnoreCase(@RequestParam String categoryName){
        return this.categoryService.getByCategoryNameContainsIgnoreCase(categoryName);
    }

    @GetMapping(value = "/getByDescriptionContains")
    DataResult<List<Category>> getByDescriptionContains(@RequestParam String description){
        return this.categoryService.getByDescriptionContains(description);
    }

    @GetMapping(value = "/getByCategoryNameContainsOrDescriptionContains")
    DataResult<List<Category>> getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase
            (@RequestParam("categoryName") String categoryName, @RequestParam("description") String description){
        return this.categoryService.getByCategoryNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(categoryName, description);
    }

    @GetMapping(value = "/getByCategoryNameStartingWith")
    DataResult<List<Category>> getByCategoryNameStartingWith(@RequestParam String categoryName) {
        return this.categoryService.getByCategoryNameStartingWith(categoryName);
    }
}
