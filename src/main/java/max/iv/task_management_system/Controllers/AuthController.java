package max.iv.task_management_system.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "the authorization controller",
        description = "Contains methods for user authorization")
public class AuthController {
    private final AuthenticationServiceImpl authenticationService;
    @PostMapping("/sign-up")
    @Operation(summary = "user authorization ",
            description = "user authorization based on incoming data,getting a token and a refresh token")
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
    @Operation(summary = " getting a token",
            description = "getting a token based on a refresh token if the time is up")
    public JwtAuthenticationDTO refresh(@RequestBody RefreshTokenDTO refreshTokenDto) throws Exception {
        return authenticationService.refreshToken(refreshTokenDto);
    }
}
