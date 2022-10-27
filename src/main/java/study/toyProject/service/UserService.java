package study.toyProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.toyProject.dto.user.requestDto.UserJoinRequestDto;
import study.toyProject.entity.user.User;
import study.toyProject.repository.user.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userSave(UserJoinRequestDto userJoinRequestDto) {
        User user = User.builder()
                .userID(userJoinRequestDto.getUserID())
                .password(userJoinRequestDto.getPassword())
                .email(userJoinRequestDto.getEmail())
                .phone(userJoinRequestDto.getPhone())
                .gender(userJoinRequestDto.getGender())
                .age(userJoinRequestDto.getAge())
                .build();
        User saveUser = userRepository.save(user);

        return saveUser;
    }
}
