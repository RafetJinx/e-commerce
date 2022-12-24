package design.ecommerce.core.dataAccess;

import design.ecommerce.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User getByEmail(String email);

    @Transactional
    Integer deleteByEmail(String email);
}
