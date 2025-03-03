package max.iv.task_management_system;

import com.fasterxml.jackson.databind.ObjectMapper;
import max.iv.task_management_system.controllers.TaskController;
import max.iv.task_management_system.dto.TaskDTO;
import max.iv.task_management_system.dto.TaskResponse;
import max.iv.task_management_system.models.Task;
import max.iv.task_management_system.repository.TaskRepository;
import max.iv.task_management_system.security.Jwt.JwtFilter;
import max.iv.task_management_system.services.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static max.iv.task_management_system.models.Enums.Priority.HIGH;
import static max.iv.task_management_system.models.Enums.Status.PENDING;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {TaskController.class},
        excludeAutoConfiguration = SecurityAutoConfiguration.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = JwtFilter.class))
@ExtendWith(MockitoExtension.class)
public class ControllerTest {
        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper mapper;
        @InjectMocks
        private TaskController taskController;
        @MockitoBean
        private TaskServiceImpl taskService;
        @MockitoBean
        private TaskRepository repository;
        private TaskDTO taskDTO;
        private Pageable pageable;


        @BeforeEach
        void init() {
            taskDTO =  TaskDTO.builder()
                    .title("title")
                    .description("description")
                    .status(PENDING)
                    .priority(HIGH)
                    .author("1@1")
                    .executor("5@5")
                    .build();
            pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "taskUUId"));

            Task newTask  = new Task();

        }

        @Test
        public void testGetAllTasks() throws Exception {
            //given
            Page<TaskDTO> taskPage = new PageImpl<>(Collections.singletonList(taskDTO), pageable, 1);
            TaskResponse taskResponse = new TaskResponse(taskPage);

            // when
            when(this.taskService.getAllTasks(pageable)).thenReturn(taskResponse);
            //then
            mvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(mapper.writeValueAsString(taskResponse)));
        }
        @Test
        public void testGetTask()throws Exception {
            //given
            Task newTask  = new Task();
            repository.save(newTask);


            // when


            //then

        }
          //given
          // when
          //then

    }


