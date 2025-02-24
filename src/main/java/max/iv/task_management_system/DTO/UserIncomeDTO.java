package max.iv.task_management_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.iv.task_management_system.Models.Enums.Roles;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIncomeDTO {
    private String password;
    private String email;
    private Roles roles ;
}
