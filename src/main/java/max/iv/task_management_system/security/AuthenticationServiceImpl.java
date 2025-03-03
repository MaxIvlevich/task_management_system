package max.iv.task_management_system.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.dto.JwtAuthenticationDTO;
import max.iv.task_management_system.dto.RefreshTokenDTO;
import max.iv.task_management_system.dto.UserCredentialsDTO;
import max.iv.task_management_system.dto.UserIncomeDTO;
import max.iv.task_management_system.models.User;
import max.iv.task_management_system.repository.UserRepository;
import max.iv.task_management_system.security.Interface.AuthenticationService;
import max.iv.task_management_system.security.Jwt.JwtService;
import max.iv.task_management_system.services.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserServiceImpl userService;



    @Override
    @Transactional
    public JwtAuthenticationDTO signUp (UserCredentialsDTO userCredentialsDTO) throws AuthenticationException {
        log.info("Попытка зайти {}",userCredentialsDTO);
        User user = findByCredentials(userCredentialsDTO);
        return jwtService.generateAuthToken(user.getEmail());
    }

    @Override
    public JwtAuthenticationDTO registrationNewUser(UserIncomeDTO userIncomeDTO) {

       if(userRepository.findByEmail(userIncomeDTO.getEmail()).isPresent()){
           return null;
       } else{
          User user =  userService.createUser(userIncomeDTO);
           return jwtService.generateAuthToken(user.getEmail());
       }
    }

    @Override
    @Transactional
    public JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDto) {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if (refreshToken != null && jwtService.validateJwtToken(refreshToken)) {
            User user = findByEmail(jwtService.getEmailFromToken(refreshToken));
            return jwtService.refreshBaseToken(user.getEmail(), refreshToken);
        }
        try {
            throw new  AuthenticationException("Invalid refresh token");
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

    }


    private User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email).orElseThrow(()->
                    new Exception(String.format("User with email %s not found", email)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private User findByCredentials(UserCredentialsDTO userCredentialsDto) throws AuthenticationException {
        Optional<User> optionalUser = userRepository.findByEmail(userCredentialsDto.getEmail());
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())){
                return user;
            }
        }
        throw new AuthenticationException("Email or password is not correct");
    }

}

