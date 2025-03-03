package max.iv.task_management_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.dto.JwtAuthenticationDTO;
import max.iv.task_management_system.dto.RefreshTokenDTO;
import max.iv.task_management_system.dto.UserCredentialsDTO;
import max.iv.task_management_system.security.AuthenticationServiceImpl;
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
