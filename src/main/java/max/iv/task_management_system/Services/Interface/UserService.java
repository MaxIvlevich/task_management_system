package max.iv.task_management_system.Services.Interface;

import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.Models.User;

public interface UserService {

    UserDTO createUser(User user);

}
