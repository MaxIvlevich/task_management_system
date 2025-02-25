package max.iv.task_management_system.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.JwtAuthenticationDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;
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
public class UserController {

    private final AuthenticationServiceImpl authenticationService;
    @PostMapping("/registration")
    public ResponseEntity<JwtAuthenticationDTO> crateUser(@RequestBody UserIncomeDTO UserIncomeDTO){
        return new  ResponseEntity<>(authenticationService.registrationNewUser(UserIncomeDTO), HttpStatus.OK);

    }






}
