package max.iv.task_management_system.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.IncomeTaskDto;
import max.iv.task_management_system.DTO.TaskDTO;
import max.iv.task_management_system.DTO.TaskResponse;
import max.iv.task_management_system.Services.TaskServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    @GetMapping("/tasks")
    private ResponseEntity<TaskResponse> getAllTasks(){
        return new ResponseEntity<>(taskServiceImpl.getAllTasks(), HttpStatus.OK);

    }
    @GetMapping("/task/{TASK_UUID}")
    private ResponseEntity<TaskDTO> getTask(@PathVariable UUID TASK_UUID){
        return new ResponseEntity<>(taskServiceImpl.findTaskById(TASK_UUID), HttpStatus.OK);

    }
    @PutMapping("/task/{TASK_UUID}")
    private ResponseEntity<TaskDTO> updateTask(@PathVariable UUID TASK_UUID,@RequestBody IncomeTaskDto updatedTask){
        return new ResponseEntity<>(taskServiceImpl.updateTask(TASK_UUID,updatedTask), HttpStatus.OK);

    }

}
