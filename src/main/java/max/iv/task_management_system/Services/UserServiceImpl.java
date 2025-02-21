package max.iv.task_management_system.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.UserDTO;
import max.iv.task_management_system.Models.User;
import max.iv.task_management_system.Repository.UserRepository;
import max.iv.task_management_system.Services.Interface.UserService;
import max.iv.task_management_system.mapper.UserDTOMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public UserDTO createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) {
            log.info("the user already exists");
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);

         return UserDTOMapper.UserToDto(user);
    }
}
