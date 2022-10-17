package study.toyProject.entity.consult;

import lombok.*;
import study.toyProject.dto.requestDto.ConsultSaveRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "ConsultInfoBuilder")
public class ConsultInfo {

    @Id @GeneratedValue
    private Long seq;
    private String consultType;
    private String title;

    @Column(columnDefinition = "Text")
    private String contents;

    private String phone;
    private String email;
    private String userID;
    private String manageID;
    private String status;
    private String searchPhone;
    private LocalDateTime regDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "consultInfo")
    List<ConsultFile> files = new ArrayList<>();

    public static ConsultInfoBuilder builder(ConsultSaveRequestDto consultSaveRequestDto) {
        return ConsultInfoBuilder()
                .consultType(consultSaveRequestDto.getConsultType())
                .title(consultSaveRequestDto.getTitle())
                .contents(consultSaveRequestDto.getContents())
                .phone(consultSaveRequestDto.getPhone())
                .email(consultSaveRequestDto.getEmail())
                .userID(consultSaveRequestDto.getUserID())
                .status(consultSaveRequestDto.getStatus())
                .searchPhone(consultSaveRequestDto.getSearchPhone());
    }
}
