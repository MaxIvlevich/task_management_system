package max.iv.task_management_system.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private  long time;
    private String errorMassage;
}
