package max.iv.task_management_system.services.Interface;

import max.iv.task_management_system.dto.IncomeTaskDto;
import max.iv.task_management_system.dto.TaskDTO;
import max.iv.task_management_system.dto.TaskResponse;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

public interface TaskService {
     TaskResponse getAllTasks(Pageable pageable);

     TaskDTO updateTask(UUID taskUUID, IncomeTaskDto incomeTaskDto, String email);

     void deleteTask(UUID uuid);

     TaskDTO createNewTask(IncomeTaskDto incomeTaskDto);

     TaskDTO findTaskById(UUID uuid);

     TaskResponse getTaskByAuthorEmail(String email,Pageable pageable);

    Object getTaskByExecutorEmail(String executorEmail, Pageable pageable);

}
