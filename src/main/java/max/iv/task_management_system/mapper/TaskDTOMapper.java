package max.iv.task_management_system.mapper;

import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.Models.Task;


public class TaskDTOMapper {
    public static TaskDTO taskToDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setAuthor(task.getAuthor().getEmail());
        taskDTO.setExecutor(task.getExecutor().getEmail());

        return taskDTO;


    }
}
