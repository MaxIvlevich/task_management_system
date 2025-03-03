package max.iv.task_management_system.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import max.iv.task_management_system.models.Enums.Priority;
import max.iv.task_management_system.models.Enums.Status;

import java.util.UUID;

@Data
@Entity
@Schema(description = "The task entity model")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "unique Task ID")
    private UUID taskUUId;
    @Schema(description = " Task title")
    private String title;
    @Schema(description = "Task description")
    private String description;
    @Schema(description = " Task status",example = "IN_PROGRESS")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Schema(description = "Task priority",example = "MEDIUM")
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Schema(description = "comment on the Task")
    private String comment;
    @Schema(description = "the author of the Task")
    @JoinColumn
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @NotNull
    private User author;
    @Schema(description = "executor of the Task")
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn
    @NotNull
    private User executor;
}
