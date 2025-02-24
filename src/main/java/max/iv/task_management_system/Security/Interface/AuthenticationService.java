package max.iv.task_management_system.Security.Interface;

import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Security.Jwt.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signUp(UserIncomeDTO UserIncomeDTO);
}
