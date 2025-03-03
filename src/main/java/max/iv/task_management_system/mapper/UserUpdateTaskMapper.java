package max.iv.task_management_system.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import max.iv.task_management_system.dto.IncomeTaskDto;
import max.iv.task_management_system.models.Task;
@Schema(description = "update Task  for income data ")
public class UserUpdateTaskMapper {
    public static Task updateTask(Task taskUpdate, IncomeTaskDto taskIncomeDto){

        if(taskIncomeDto.getStatus()!=null){
            taskUpdate.setStatus(taskIncomeDto.getStatus());
        }
        if(taskIncomeDto.getComment()!=null){
            taskUpdate.setComment(taskIncomeDto.getComment());
        }

        return taskUpdate;

    }
}
