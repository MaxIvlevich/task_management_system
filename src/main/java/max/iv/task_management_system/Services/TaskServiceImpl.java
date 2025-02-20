package max.iv.task_management_system.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Models.Task;
import max.iv.task_management_system.Repository.TaskRepository;
import max.iv.task_management_system.Services.Interface.TaskService;
import max.iv.task_management_system.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public TaskResponse getAllTasks() {
        log.info("Calling all Tasks");
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(TaskMapper::taskToDTO)
                .collect(Collectors.toList());
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setContent(taskDTOs);
        return taskResponse;
    }

    @Override
    public TaskDTO updateTask(UUID taskUUID,IncomeTaskDto incomeTaskDto) {


        return null;
    }

    @Override
    public void deleteTask(IncomeTaskDto incomeTaskDto) {

    }

    @Override
    public TaskDTO createNewTask(IncomeTaskDto incomeTaskDto) {
        return null;
    }

    @Override
    public TaskDTO findTaskById(UUID uuid) {
        Task task = taskRepository.findById(uuid)
                .orElseThrow(()-> new IllegalArgumentException("Task not found"));
        return TaskMapper.taskToDTO(task);



    }
}
