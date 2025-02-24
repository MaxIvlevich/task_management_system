package max.iv.task_management_system.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;
import max.iv.task_management_system.Security.AuthenticationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationServiceImpl authenticationService;
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid UserIncomeDTO userIncomeDTO) {
        return authenticationService.signUp(userIncomeDTO);
    }
}
