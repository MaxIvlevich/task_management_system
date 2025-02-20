package max.iv.task_management_system.Services.Interface;

import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Models.Task;

import java.util.UUID;

public interface TaskService {
     TaskResponse getAllTasks();

     TaskDTO editTask(TaskDTO taskDTO);

     void deleteTask(TaskDTO taskDTO);

     TaskDTO createNewTask(TaskDTO taskDTO);

     TaskDTO findTaskById(UUID uuid);
}
