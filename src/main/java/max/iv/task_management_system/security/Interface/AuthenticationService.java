package max.iv.task_management_system.security.Interface;

import max.iv.task_management_system.dto.JwtAuthenticationDTO;
import max.iv.task_management_system.dto.RefreshTokenDTO;
import max.iv.task_management_system.dto.UserCredentialsDTO;
import max.iv.task_management_system.dto.UserIncomeDTO;

import javax.naming.AuthenticationException;

public interface AuthenticationService {

    JwtAuthenticationDTO signUp(UserCredentialsDTO UserIncomeDTO) throws AuthenticationException;

    JwtAuthenticationDTO registrationNewUser(UserIncomeDTO userIncomeDTO);

    JwtAuthenticationDTO refreshToken(RefreshTokenDTO refreshTokenDto);

}
