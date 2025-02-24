package max.iv.task_management_system.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationDTO {
    private String token;
    private String refreshToken;
}
