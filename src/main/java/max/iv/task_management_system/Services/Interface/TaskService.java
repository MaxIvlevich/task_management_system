package max.iv.task_management_system.Services.Interface;

import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Models.Task;

import java.util.UUID;

public interface TaskService {
     TaskResponse getAllTasks();

     TaskDTO updateTask(UUID taskUUID,IncomeTaskDto incomeTaskDto);

     void deleteTask(IncomeTaskDto incomeTaskDto);

     TaskDTO createNewTask(IncomeTaskDto incomeTaskDto);

     TaskDTO findTaskById(UUID uuid);
}
