package max.iv.task_management_system.Security.Jwt;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;
}
