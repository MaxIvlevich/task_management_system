package max.iv.task_management_system.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import max.iv.task_management_system.dto.TaskDTO;
import max.iv.task_management_system.models.Task;

@Schema(description = "creates a DTO object for the Task entity")
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
