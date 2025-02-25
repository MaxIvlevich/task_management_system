package max.iv.task_management_system.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.JwtAuthenticationDTO;
import max.iv.task_management_system.DTO.RefreshTokenDTO;
import max.iv.task_management_system.DTO.UserCredentialsDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;
import max.iv.task_management_system.Security.AuthenticationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationServiceImpl authenticationService;
    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationDTO> signUp(@RequestBody  UserCredentialsDTO userCredentialsDTO) {
        log.info("Income user DTO {}",userCredentialsDTO);


        try {
           JwtAuthenticationDTO jwtAuthenticationDTO = authenticationService.signUp(userCredentialsDTO);
            return ResponseEntity.ok(jwtAuthenticationDTO);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PostMapping("/refresh")
    public JwtAuthenticationDTO refresh(@RequestBody RefreshTokenDTO refreshTokenDto) throws Exception {
        return authenticationService.refreshToken(refreshTokenDto);
    }
}
