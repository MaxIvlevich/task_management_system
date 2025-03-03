package max.iv.task_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.iv.task_management_system.models.Enums.Priority;
import max.iv.task_management_system.models.Enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String author;
    private String executor;


}
