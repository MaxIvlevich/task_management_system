package max.iv.task_management_system.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.dto.IncomeTaskDto;
import max.iv.task_management_system.dto.TaskDTO;
import max.iv.task_management_system.dto.TaskResponse;
import max.iv.task_management_system.exceptions.TaskAlreadyExistsException;
import max.iv.task_management_system.models.Task;
import max.iv.task_management_system.repository.TaskRepository;
import max.iv.task_management_system.repository.UserRepository;
import max.iv.task_management_system.services.Interface.TaskService;
import max.iv.task_management_system.mapper.TaskDTOMapper;
import max.iv.task_management_system.mapper.TaskMapper;
import max.iv.task_management_system.mapper.UpdateMapper;
import max.iv.task_management_system.mapper.UserUpdateTaskMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * A service for working with Tasks
 * contains methods for adding deleting retrieving and modifying tasks
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UpdateMapper updateMapper;
    private final UserRepository userRepository;

    /**
     * The method for getting all paginated  tasks
     * @param pageable parameter for pagination
     * @return TaskResponse contains a list of tasks
     */
    @Override
    @Transactional
    public TaskResponse getAllTasks(Pageable pageable) {
        log.info("Calling all Tasks");

        List<Task> tasks = (List<Task>) taskRepository.findAll();
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(TaskDTOMapper::taskToDTO)
                .toList();

        return new TaskResponse(new  PageImpl<>(taskDTOs,pageable,taskDTOs.size()));


    }

    /**
     *a method for updating an issue. Updates the fields depending on the rights ,
     * if Admin then everything , if User  then only the fields status and comments
     * @param taskUUID Task id  value UUID
     * @param incomeTaskDto  DTO of the task to update
     * @param userEmail email of the user who updates the Task  value String
     * @return TaskDTO  DTO of the updated task
     */
    @Override
    @Transactional
    public TaskDTO updateTask(UUID taskUUID,IncomeTaskDto incomeTaskDto,String userEmail)  {

        if(!taskRepository.existsById(taskUUID)){
            log.info("Task not exist with ID{}",taskUUID);
            throw new IllegalArgumentException();

        }
        if(userRepository.findByEmail(userEmail).get().isAdmin()){
            log.info("Update Task: {}",incomeTaskDto.getTitle());
            Task task = taskRepository.findById(taskUUID)
                    .orElseThrow(()-> new IllegalArgumentException("Task not found"));
            taskRepository.save(updateMapper.updateTask(task,incomeTaskDto));
            log.info("The task has been updated");
            return TaskDTOMapper.taskToDTO(task);

        } else {
            log.info("User {} Update Task: {}",userEmail,incomeTaskDto.getTitle());
            Task task = taskRepository.findById(taskUUID)
                    .orElseThrow();
            taskRepository.save(UserUpdateTaskMapper.updateTask(task,incomeTaskDto));
            log.info("The task has been updated");
            return TaskDTOMapper.taskToDTO(task);

        }
    }

    /**
     * Deleting an Task by id
     * @param taskUUID Task id  value UUID
     */
    @Override
    @Transactional
    public void deleteTask(UUID taskUUID) {

        log.info("Deleting a Task: {}",taskUUID);
        taskRepository.deleteById(taskUUID);
        log.info("Task Deleted");
    }

    /**
     * Creates a new task for incomeTaskDto
     * @param incomeTaskDto DTO for incoming task fields
     * @return TaskDTO DTO of the created task
     */
    @Override
    @Transactional
    public TaskDTO createNewTask(IncomeTaskDto incomeTaskDto) {

        if (incomeTaskDto.getTaskUUId() != null ) {
            log.info("the Task already exists");
            throw new TaskAlreadyExistsException("the Task already exists");
        }

        Task newTask = taskMapper.toTask(incomeTaskDto);
        log.info("Created new Task with title: {}", newTask.getTitle());
        taskRepository.save(newTask);

        return TaskDTOMapper.taskToDTO(newTask);

    }

    /**
     * Searches for a task in the repository by id
     * @param uuid Task id  value UUID
     * @return TaskDTO DTO for found task
     */
    @Override
    @Transactional
    public TaskDTO findTaskById(UUID uuid) {
        Task task = taskRepository.findById(uuid)
                .orElseThrow(()-> new IllegalArgumentException("Task not found"));
        return TaskDTOMapper.taskToDTO(task);

    }

    /**
     * Receives the task list by  Author email address
     * @param email email of the user who is the Author of the Task. String value
     * @param pageable parameter for pagination
     * @return TaskResponse  contains a list of tasks
     */

    @Override
    @Transactional
    public TaskResponse getTaskByAuthorEmail(String email,Pageable pageable) {
        log.info("Calling all Tasks by Email {}",email);

        List<Task> tasks = taskRepository.findTaskByAuthor(userRepository
                .findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException(email)),pageable);

        List<TaskDTO> taskDTOs = tasks.stream()
                .map(TaskDTOMapper::taskToDTO)
                .toList();

        return new TaskResponse(new  PageImpl<>(taskDTOs,pageable,taskDTOs.size()));




    }

    /**
     * Receives the task list by Executor email address
     * @param executorEmail email of the user who is the Executor of the Task. String value
     * @param pageable parameter for pagination
     * @return TaskResponse contains a list of tasks
     */

    @Override
    public TaskResponse getTaskByExecutorEmail(String executorEmail, Pageable pageable) {
        log.info("Calling all Tasks by executorEmail Email {}",executorEmail);
        List<Task> tasks = taskRepository.findTaskByExecutor(userRepository
                .findByEmail(executorEmail)
                .orElseThrow( () -> new UsernameNotFoundException(executorEmail)),pageable);

        List<TaskDTO> taskDTOs = tasks.stream()
                .map(TaskDTOMapper::taskToDTO)
                .toList();

        return new TaskResponse(new  PageImpl<>(taskDTOs,pageable,taskDTOs.size()));


    }
}
