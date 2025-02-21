package max.iv.task_management_system.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.Models.User;
import max.iv.task_management_system.Services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping("/crateuser")
    public ResponseEntity<UserDTO> crateUser( @RequestBody User user){
        return new  ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

    }






}
