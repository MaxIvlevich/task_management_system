package max.iv.task_management_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.iv.task_management_system.Models.Enums.Priority;
import max.iv.task_management_system.Models.Enums.Status;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeTaskDto {
    private UUID taskUUId;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String authorEmail;
    private String executorEmail;
    private String comment;
}
