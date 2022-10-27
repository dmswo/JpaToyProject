package study.toyProject.dto.user.requestDto;

import lombok.Data;

@Data
public class UserJoinRequestDto {

    private String userID;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private int age;
}
