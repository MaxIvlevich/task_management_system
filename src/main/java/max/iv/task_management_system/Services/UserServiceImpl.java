package max.iv.task_management_system.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.DTO.UserIncomeDTO;
import max.iv.task_management_system.Models.User;
import max.iv.task_management_system.Repository.UserRepository;
import max.iv.task_management_system.Services.Interface.UserService;
import max.iv.task_management_system.mapper.UserDTOMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
   @Override
    public User createUser(UserIncomeDTO userIncomeDTO) {
        String email = userIncomeDTO.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            log.info("the user already exists");
            return null;
        }

        log.info("Saving new User with email: {}", email);


        return userRepository.save(UserDTOMapper.UserToDto(userIncomeDTO));
    }




}
