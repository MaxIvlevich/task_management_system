package max.iv.task_management_system.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.iv.task_management_system.Models.Enums.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
@Schema(description = "The user's identity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Unique user ID")
    private UUID userUUId;
    @Schema(description = "User Email")
    @Column(nullable = false)
    private String email;
    @Schema(description = "User password,encoded")
    @Column(nullable = false)
    private String password;
    @Schema(description = "User role", example = "ADMIN_ROLE")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roles ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
    private List<Task> tasksAuthor = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "executor")
    private List<Task> tasksExecutor = new ArrayList<>();



    public boolean isAdmin(){
        return  roles.equals(Roles.ROLE_ADMIN);
    }

}
