package max.iv.task_management_system.Services.Interface;

import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

public interface TaskService {
     TaskResponse getAllTasks(Pageable pageable);

     TaskDTO updateTask(UUID taskUUID, IncomeTaskDto incomeTaskDto, String email);

     void deleteTask(UUID uuid);

     TaskDTO createNewTask(IncomeTaskDto incomeTaskDto);

     TaskDTO findTaskById(UUID uuid);

     TaskResponse getTaskByUserEmail(String email,Pageable pageable);
}
