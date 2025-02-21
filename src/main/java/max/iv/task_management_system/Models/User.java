package max.iv.task_management_system.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import max.iv.task_management_system.Models.Enums.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userUUId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roles ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
    private List<Task> tasksAuthor = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "executor")
    private List<Task> tasksExecutor = new ArrayList<>();


    public String getUsername() {
        return email;
    }
    public boolean idAdmin(){
        return  roles.equals(Roles.ROLE_ADMIN);
    }


}
