package max.iv.task_management_system.repository;

import jakarta.validation.constraints.NotNull;
import max.iv.task_management_system.models.Task;
import max.iv.task_management_system.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TaskRepository extends CrudRepository<Task, UUID>{


   List<Task> findTaskByAuthor(@NotNull User author, Pageable pageable);
   List<Task> findTaskByExecutor(@NotNull User executor,Pageable pageable);

}
