package max.iv.task_management_system.Repository;

import jakarta.persistence.LockModeType;
import max.iv.task_management_system.Models.User;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    User findByEmail(String email);
}
