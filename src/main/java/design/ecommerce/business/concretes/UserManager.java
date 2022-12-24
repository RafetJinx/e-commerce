package design.ecommerce.business.concretes;

import design.ecommerce.business.abstracts.UserService;
import design.ecommerce.core.dataAccess.UserDao;
import design.ecommerce.core.entities.User;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.core.utilities.results.dataResult.success.SuccessDataResult;
import design.ecommerce.core.utilities.results.successResult.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result addUser(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public DataResult<List<User>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<User>>(this.userDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<User>> getAllSortedByIdAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return new SuccessDataResult<List<User>>(this.userDao.findAll(sort));
    }

    @Override
    public DataResult<List<User>> getAllSortedByIdDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new SuccessDataResult<List<User>>(this.userDao.findAll(sort));
    }

    @Override
    public DataResult<List<User>> getAllSortedByEmailAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "email");
        return new SuccessDataResult<List<User>>(this.userDao.findAll(sort));
    }

    @Override
    public DataResult<List<User>> getAllSortedByEmailDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "email");
        return new SuccessDataResult<List<User>>(this.userDao.findAll(sort));
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email));
    }

    @Override
    public DataResult<Integer> deleteByEmail(String email) {
        return new SuccessDataResult<Integer>("Kullanici Silindi", this.userDao.deleteByEmail(email));
    }
}
