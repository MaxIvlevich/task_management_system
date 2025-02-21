package max.iv.task_management_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.iv.task_management_system.Models.Enums.Roles;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID userUUId;
    private String email;
    private Roles roles ;
}
