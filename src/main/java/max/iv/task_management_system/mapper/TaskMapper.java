package max.iv.task_management_system.mapper;

import lombok.AllArgsConstructor;
import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.Models.Task;
import max.iv.task_management_system.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
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
