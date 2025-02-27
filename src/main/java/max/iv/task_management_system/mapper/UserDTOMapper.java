package max.iv.task_management_system.mapper;

import io.swagger.v3.oas.annotations.media.Schema;
import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Schema(description = "creates a new User  for income User data")
public class UserDTOMapper {
    static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static User UserToDto(UserIncomeDTO userIncomeDTO) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(userIncomeDTO.getPassword()));
        user.setEmail(userIncomeDTO.getEmail());
        user.setRoles(userIncomeDTO.getRoles());
        return user;
    }

}
