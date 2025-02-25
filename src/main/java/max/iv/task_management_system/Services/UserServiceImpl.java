package max.iv.task_management_system.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.Models.User;
import max.iv.task_management_system.Repository.UserRepository;
import max.iv.task_management_system.Services.Interface.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
   @Override
    public User createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            log.info("the user already exists");
            return null;
        }
        log.info("Saving new User with email: {}", email);

        return userRepository.save(user);
    }




}
