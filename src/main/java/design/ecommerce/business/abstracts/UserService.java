package design.ecommerce.business.abstracts;

import design.ecommerce.core.entities.User;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;

import java.util.List;

public interface UserService {
    Result addUser(User user);

    DataResult<List<User>> getAll();

    DataResult<List<User>> getAll(int pageNo, int pageSize);

    DataResult<List<User>> getAllSortedByIdAsc();
    DataResult<List<User>> getAllSortedByIdDesc();

    DataResult<List<User>> getAllSortedByEmailAsc();
    DataResult<List<User>> getAllSortedByEmailDesc();

    DataResult<User> getByEmail(String email);

    DataResult<Integer> deleteByEmail(String email);
}
