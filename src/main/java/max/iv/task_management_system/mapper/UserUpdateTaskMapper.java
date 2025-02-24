package max.iv.task_management_system.mapper;

import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.Models.Task;

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
