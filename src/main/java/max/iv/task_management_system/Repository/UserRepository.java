package max.iv.task_management_system.Repository;

import jakarta.persistence.LockModeType;
import jakarta.validation.constraints.NotNull;
import max.iv.task_management_system.Models.User;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @NotNull
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
