package max.iv.task_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;
import max.iv.task_management_system.Models.Enums.Priority;
import max.iv.task_management_system.Models.Enums.Status;

import java.util.UUID;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskUUId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String comment;
    @ManyToOne
    @JoinColumn
    private User author;
    @ManyToOne
    @JoinColumn
    private User executor;



}
