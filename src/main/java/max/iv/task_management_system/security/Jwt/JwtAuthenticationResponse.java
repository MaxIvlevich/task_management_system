package max.iv.task_management_system.security.Jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAuthenticationResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
