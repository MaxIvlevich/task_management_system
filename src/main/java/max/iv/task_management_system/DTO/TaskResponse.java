package max.iv.task_management_system.DTO;

import lombok.Data;

import java.util.List;
@Data
public class TaskResponse {
    private List<TaskDTO> content;
}
