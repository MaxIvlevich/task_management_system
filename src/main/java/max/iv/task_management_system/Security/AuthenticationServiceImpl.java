package max.iv.task_management_system.Security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Interface.AuthenticationService;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;
import max.iv.task_management_system.Security.Jwt.JwtService;
import max.iv.task_management_system.Services.Interface.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    @Transactional
    public JwtAuthenticationResponse signUp (UserIncomeDTO userIncomeDTO) {
        return null;
    }
}

