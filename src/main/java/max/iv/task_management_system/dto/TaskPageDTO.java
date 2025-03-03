package max.iv.task_management_system.dto;

import lombok.Data;
import max.iv.task_management_system.models.Task;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class TaskPageDTO {
    private List<Task> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public TaskPageDTO(Page<Task> page) {
        this.content = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }



}
