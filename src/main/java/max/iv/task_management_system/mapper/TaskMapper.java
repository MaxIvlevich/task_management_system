package max.iv.task_management_system.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import max.iv.task_management_system.dto.IncomeTaskDto;
import max.iv.task_management_system.models.Task;
import max.iv.task_management_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
@Schema(description = "creates a new DTO  for income data")
public class TaskMapper {
    private  final UserRepository userRepository;

    public  Task toTask(IncomeTaskDto incomeTaskDto){
        Task newTask = new Task();

        newTask.setTitle(incomeTaskDto.getTitle());
        newTask.setDescription(incomeTaskDto.getDescription());
        newTask.setStatus(incomeTaskDto.getStatus());
        newTask.setPriority(incomeTaskDto.getPriority());
        newTask.setAuthor(userRepository.findByEmail(incomeTaskDto.getAuthorEmail())
                .orElseThrow(() -> new UsernameNotFoundException(incomeTaskDto.getAuthorEmail())));
        newTask.setExecutor(userRepository.findByEmail(incomeTaskDto.getExecutorEmail())
                .orElseThrow(() -> new UsernameNotFoundException(incomeTaskDto.getExecutorEmail())));
        newTask.setComment(incomeTaskDto.getComment());

        return newTask;


    }
}
