package max.iv.task_management_system.Services.Interface;

import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    User createUser(User user);
    UserDetailsService userDetailsService();
    User getByUsername(String username);
    User getCurrentUser();


}
