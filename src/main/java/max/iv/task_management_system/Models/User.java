package max.iv.task_management_system.Models;

import jakarta.persistence.*;
import lombok.Data;
import max.iv.task_management_system.Models.Enums.Roles;

import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userUUId;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles ;


    public String getUsername() {
        return email;
    }
    public boolean idAdmin(){
        return  roles.equals(Roles.ROLE_ADMIN);
    }


}
