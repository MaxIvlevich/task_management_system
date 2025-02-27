package max.iv.task_management_system.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Services.TaskServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Tasks", description = "API для управления задачами")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    @GetMapping("/tasks")
    @Operation(summary = "Get All Tasks", description = "Retrieves a list of all paginated Tasks")
    private ResponseEntity<TaskResponse> getAllTasks(@PageableDefault(
            size = 20,
            page = 0,
            sort = {"taskUUId"},
            direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(taskServiceImpl.getAllTasks(pageable), HttpStatus.OK);

    }
    @GetMapping("/task/{TASK_UUID}")
    @Operation(summary = "Get  Tasks by taskUUID ", description = "Returns the Task by the Indicated id ")
    private ResponseEntity<TaskDTO> getTask(@PathVariable UUID TASK_UUID){
        return new ResponseEntity<>(taskServiceImpl.findTaskById(TASK_UUID), HttpStatus.OK);

    }
    @PutMapping("/task/{TASK_UUID}")
    @Operation(summary = "updates her task if she has the rights ", description = "returns the updated Task ")
    private ResponseEntity<TaskDTO> updateTask(@PathVariable UUID TASK_UUID,
                                               @RequestBody IncomeTaskDto updatedTask,
                                               @AuthenticationPrincipal UserDetails userDetailService){
        return new ResponseEntity<>(taskServiceImpl.updateTask(TASK_UUID,updatedTask,userDetailService.getUsername()), HttpStatus.OK);

    }
    @PostMapping("/task")
    @Operation(summary = "creates a new task ", description = "creates a new task with the specified parameters ")
    private ResponseEntity<TaskDTO> createTask(@RequestBody IncomeTaskDto createdTask){
        log.info("Создаем задачу {} ",createdTask);
        return new ResponseEntity<>(taskServiceImpl.createNewTask(createdTask), HttpStatus.OK);

    }
    @DeleteMapping("/task/{TASK_UUID}")
    @Operation(summary = "Delete a Task  ", description = "Deletes an Task by the specified ID ")
    private String deleteTask(@PathVariable UUID TASK_UUID){
        taskServiceImpl.deleteTask(TASK_UUID);
        return "Task Deleted";

    }
    @GetMapping("/tasks/author/{Author_Email}")
    @Operation(summary = "Gets the task list ", description = "Gets the task list of the specified author ,paginated,by the specified Email address ")
    private ResponseEntity<TaskResponse> getAuthorTask(@PathVariable String Author_Email, @PageableDefault(
            size = 20,
            page = 0,
            sort = {"taskUUId"},
            direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(taskServiceImpl.getTaskByUserEmail(Author_Email,pageable), HttpStatus.OK);

    }
    @GetMapping("/tasks/executor/{Executor_Email}")
    @Operation(summary = "Gets the task list ", description = "Gets the task list of the specified Executor ,paginated, by the specified Email address")
    private ResponseEntity<TaskResponse> getExecutorTask(@PathVariable String Executor_Email,@PageableDefault(
            size = 20,
            page = 0,
            sort = {"taskUUId"},
            direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(taskServiceImpl.getTaskByExecutorEmail(Executor_Email,pageable), HttpStatus.OK);
    }

}
