package max.iv.task_management_system.Services;

import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Services.Interface.TaskService;

import java.util.UUID;

public class TaskServiceImpl implements TaskService {

    @Override
    public TaskResponse getAllTasks() {
        return null;
    }

    @Override
    public TaskDTO editTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteTask(TaskDTO taskDTO) {

    }

    @Override
    public TaskDTO createNewTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO findTaskById(UUID uuid) {
        return null;
    }
}
