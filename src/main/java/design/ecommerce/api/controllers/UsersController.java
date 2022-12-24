package design.ecommerce.api.controllers;

import design.ecommerce.business.abstracts.UserService;
import design.ecommerce.core.entities.User;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.core.utilities.results.dataResult.error.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.addUser(user));
    }

    @GetMapping(value = "/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping(value = "/getAllByPage")
    public DataResult<List<User>> getAll(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return this.userService.getAll(pageNo, pageSize);
    }

    @GetMapping(value = "/getAllSortedByIdAsc")
    public DataResult<List<User>> getAllSortedByIdAsc(){
        return this.userService.getAllSortedByIdAsc();
    }

    @GetMapping(value = "/getAllSortedByIdDesc")
    public DataResult<List<User>> getAllSortedByIdDesc(){
        return this.userService.getAllSortedByIdDesc();
    }

    @GetMapping(value = "/getAllSortedByEmailAsc")
    public DataResult<List<User>> getAllSortedByEmailAsc(){
        return this.userService.getAllSortedByEmailAsc();
    }

    @GetMapping(value = "/getAllSortedByEmailDesc")
    public DataResult<List<User>> getAllSortedByEmailDesc(){
        return this.userService.getAllSortedByEmailDesc();
    }

    @GetMapping(value = "/getByEmail")
    public DataResult<User> getByEmail(@RequestParam String email) {
        return this.userService.getByEmail(email);
    }

    @DeleteMapping(value = "/deleteByEmail")
    public DataResult<Integer> deleteByEmail(@RequestParam String email) {
        return this.userService.deleteByEmail(email);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<>();

        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<>("Doğrulama Hataları", validationErrors);
        return errors;
    }
}
