package max.iv.task_management_system.DTO;

import lombok.Data;
import max.iv.task_management_system.Models.Task;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
public class TaskResponse {
    private List<TaskDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;


    public TaskResponse(Page<TaskDTO> page) {
        this.content = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
