package study.toyProject.entity.consult;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import study.toyProject.dto.requestDto.ConsultSaveRequestDto;
import study.toyProject.entity.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "ConsultInfoBuilder")
@EntityListeners(AuditingEntityListener.class)
public class ConsultInfo extends BaseEntity {

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
