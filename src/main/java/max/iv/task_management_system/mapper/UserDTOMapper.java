package max.iv.task_management_system.mapper;

import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.Models.User;

public class UserDTOMapper {

    public static UserDTO UserToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }






}
