package max.iv.task_management_system.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.iv.task_management_system.dto.UserIncomeDTO;
import max.iv.task_management_system.models.User;
import max.iv.task_management_system.repository.UserRepository;
import max.iv.task_management_system.services.Interface.UserService;
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
