package max.iv.task_management_system.Security.Interface;

import max.iv.task_management_system.DTO.JwtAuthenticationDTO;
import max.iv.task_management_system.DTO.RefreshTokenDTO;
import max.iv.task_management_system.DTO.UserCredentialsDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;

import javax.naming.AuthenticationException;

public interface AuthenticationService {

    JwtAuthenticationDTO signUp(UserCredentialsDTO UserIncomeDTO) throws AuthenticationException;

    JwtAuthenticationDTO registrationNewUser(UserIncomeDTO userIncomeDTO);

    JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDto);

}
