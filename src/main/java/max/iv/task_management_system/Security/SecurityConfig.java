package max.iv.task_management_system.Security;

import lombok.RequiredArgsConstructor;
import max.iv.task_management_system.Security.Jwt.JwtFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth

                        .requestMatchers("/users/sign-up").permitAll()
                        .requestMatchers( "/api/swagger-ui/**", "/api/v1/api-docs/**").permitAll()
                        .requestMatchers( "/api/task/{id}").authenticated()
                        .requestMatchers( "/api/task").hasRole("ADMIN")
                        .requestMatchers( "/api/tasks").hasRole("ADMIN")

                )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception {
        return configuration.getAuthenticationManager();
    }


   @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(4);

    }

    //    eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1QDUiLCJleHAiOjE3NDA0NzQxNzB9.kVZqenV04RLD17eIm84aWYqP0LCO3V5_x2FQrrDEvhM
    //  refr   eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1QDUiLCJleHAiOjE3NDA1NTY5NzB9.J13NpkhEN8Qs08RLsMlwixv3wWJ8IrvtvjKY1yOI9XU


}
