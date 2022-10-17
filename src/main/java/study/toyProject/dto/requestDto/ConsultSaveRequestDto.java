package study.toyProject.dto.requestDto;

import lombok.Data;

@Data
public class ConsultSaveRequestDto {
    private String consultType;
    private String title;
    private String contents;
    private String phone;
    private String email;
    private String userID;
    private String status;
    private String searchPhone;
}
