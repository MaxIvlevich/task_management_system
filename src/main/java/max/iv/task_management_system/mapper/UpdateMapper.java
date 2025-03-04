package max.iv.task_management_system.mapper;

import lombok.AllArgsConstructor;
import max.iv.task_management_system.dto.IncomeTaskDto;
import max.iv.task_management_system.models.Task;
import max.iv.task_management_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
         taskUpdate.setAuthor(userRepository.findByEmail(taskIncomeDto.getAuthorEmail())
                 .orElseThrow(() -> new UsernameNotFoundException(taskIncomeDto.getAuthorEmail())));
         taskUpdate.setExecutor(userRepository.findByEmail(taskIncomeDto.getExecutorEmail())
                 .orElseThrow(() -> new UsernameNotFoundException(taskIncomeDto.getExecutorEmail())));
         taskUpdate.setComment(taskIncomeDto.getComment());
         return taskUpdate;



     }
}
