package max.iv.task_management_system.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.JwtAuthenticationDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.AuthenticationServiceImpl;
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
@Tag(name = "A controller for working with the User", description = "Contains methods for working with the user entity")
public class UserController {

    private final AuthenticationServiceImpl authenticationService;
    @PostMapping("/registration")
    @Operation(summary = "creates a new User ", description = "creates a new user from incoming data")
    public ResponseEntity<JwtAuthenticationDTO> crateUser(@RequestBody UserIncomeDTO UserIncomeDTO){
        return new  ResponseEntity<>(authenticationService.registrationNewUser(UserIncomeDTO), HttpStatus.OK);

    }






}
