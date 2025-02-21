package max.iv.task_management_system.mapper;

import lombok.AllArgsConstructor;
import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.Models.Task;
import max.iv.task_management_system.Repository.UserRepository;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateMapper {


     private  final UserRepository userRepository;

     public Task updateTask(Task taskUpdate, IncomeTaskDto taskIncomeDto){
         taskUpdate.setTitle(taskIncomeDto.getTitle());
         taskUpdate.setDescription(taskIncomeDto.getDescription());
         taskUpdate.setStatus(taskIncomeDto.getStatus());
         taskUpdate.setComment(taskIncomeDto.getComment());
         taskUpdate.setPriority(taskIncomeDto.getPriority());
         taskUpdate.setAuthor(userRepository.findByEmail(taskIncomeDto.getAuthorEmail()));
         taskUpdate.setExecutor(userRepository.findByEmail(taskIncomeDto.getExecutorEmail()));
         return taskUpdate;

     }
}
